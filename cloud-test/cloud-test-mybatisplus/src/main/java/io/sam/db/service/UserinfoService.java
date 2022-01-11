package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.sam.db.mapper.UserinfoMapper;
import io.sam.db.domain.Userinfo;
/**
 * @description 
 * @date 2021/9/6 15:39
 * @author zhuweimu
 */
@Service
public class UserinfoService extends ServiceImpl<UserinfoMapper, Userinfo> {

}
