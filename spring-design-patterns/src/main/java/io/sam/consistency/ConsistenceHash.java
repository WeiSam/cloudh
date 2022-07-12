package io.sam.consistency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.*;

/**
 * @author zhuweimu
 * @desc 一致性hash算法实现
 * 普通取模算法 hash（key）% N
 * 问题点：扩容和收缩性差，会导致路由数据大量重置，大量key被重新路由，扩展性差
 * 一致性hash算法
 * 一致性hash算法本质上也是一种取模算法，不过，不同于上边按服务器数量取模，一致性hash是对固定值2^32取模，
 * 我们可以将这2^32个值抽象成一个圆环，圆环的正上方的点代表0，顺时针排列，
 * 以此类推，1、2、3、4、5、6……直到2^32-1，而这个由2的32次方个点组成的圆环统称为hash环
 * 从hash（key）% N 变成了hash（服务器ip）% 2^32
 * 获取key对应路由服务器：
 * 从缓存对象key进行hash的位置开始，沿顺时针方向遇到的第一个服务器，便是当前对象将要缓存到的服务器。
 * 扩容或收缩只会影响一部分数据
 * 问题点：节点分布不均匀会有偏斜问题，某节点路由数据大。解决方法：引入虚拟节点
 * @date 2022/7/11 15:10
 */
public class ConsistenceHash {

    /**
     * 一个真实节点对应的虚拟节点数
     */
    private static Integer virtualNum = 100;
    /**
     * hash环，储存虚拟节点
     */
    private static TreeMap<Integer, NodeInfo> HASH_RING = new TreeMap<>();
    /**
     * 储存真实节点
     */
    private static ArrayList<NodeInfo> realNode = new ArrayList<>();
    /**
     * 真实节点与虚拟节点关系
     */
    private static HashMap<NodeInfo, List<NodeInfo>> realVirualNodeMap = new HashMap<>();


    /**
     * 添加服务节点
     * @param nodeInfo
     */
    public static synchronized void addNode(NodeInfo nodeInfo){
        //校验节点是否已存在
        if(check(nodeInfo)){
            return;
        }
        List<NodeInfo> virualInfos = new ArrayList<>();
        for (Integer i = 0; i < virtualNum; i++) {
            //创建虚拟节点
            NodeInfo node = NodeInfo.builder()
                    .type(NodeType.VIRTUAL)
                    .name(nodeInfo.name + i)
                    .key(buildKey(nodeInfo.key,i))
                    .realNode(nodeInfo)
                    .build();
            virualInfos.add(node);
            //将虚拟节点放入hash环中,value一般放真实节点值，可以少一步映射，这里放虚拟节点值为了做演示算法
            HASH_RING.put(FNV1_32_HASH(node.key),node);
        }
        realVirualNodeMap.put(nodeInfo,virualInfos);
        realNode.add(nodeInfo);
    }

    /**
     * 移除节点
     * @param nodeInfo
     */
    public static synchronized void removeNode(NodeInfo nodeInfo){
        if(!check(nodeInfo)){
            return;
        }
        realNode.remove(nodeInfo);
        realVirualNodeMap.remove(nodeInfo);
        //移除hash环
        for (Integer i = 0; i < virtualNum; i++) {
            HASH_RING.remove(FNV1_32_HASH(buildKey(nodeInfo.key,i)));
        }
    }

    /**
     * 根据路由key获取真实节点
     * @param key
     * @return
     */
    public static NodeInfo getNodeInfo(String key){
        int hash = FNV1_32_HASH(key);
        NavigableMap<Integer, NodeInfo> tailMap = HASH_RING.tailMap(hash, true);
        //路由到当前最大值，取最小值
        if (tailMap==null || tailMap.isEmpty()) {
            return HASH_RING.firstEntry().getValue().realNode;
        }
        return tailMap.firstEntry().getValue().realNode;
    }

    /**
     * 根据路由key获取虚拟节点
     * @param key
     * @return
     */
    public static NodeInfo getVirtualNodeInfo(String key){
        int hash = FNV1_32_HASH(key);
        NavigableMap<Integer, NodeInfo> tailMap = HASH_RING.tailMap(hash, true);
        return tailMap.firstEntry().getValue();
    }

    private static boolean check(NodeInfo nodeInfo) {
        return false;
    }

    public static String buildKey(String key,Integer index){
        return key+"#"+index;
    }

    /**
     * FNV1_32_HASH算法
     * @param key
     * @return
     */
    public static int FNV1_32_HASH(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++){
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0){
            hash = Math.abs(hash);
        }
        return hash;
    }


    /**
     * 节点信息
     */
    @Data
    @Builder
    public static class NodeInfo{
        /**
         * 节点类型
         */
        private NodeType type;
        private String name;
        private String key;

        /**
         * 不会这么用，只做演示
         */
        private NodeInfo realNode;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeInfo nodeInfo = (NodeInfo) o;
            return Objects.equals(name, nodeInfo.name) &&
                    Objects.equals(key, nodeInfo.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, key);
        }

    }

    @Getter
    @AllArgsConstructor
    public static enum NodeType{
        /**
         * 节点类型
         */
        REAL(1,"真实节点"),
        VIRTUAL(2,"虚拟节点");
        private Integer type;
        private String name;
    }

}
