package io.sam.dto;


import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <br>
 * <b>开发公司：</b>gosuncn<br>
 * <b>功能：</b>OfflinePersonGoodsController<br>
 * <b>@author：</b>Robin<br>
 * <b>日期：</b>  <br>
 * <b>版权所有：<b>版权所有(C)<br>
 */
public class OfflinePersonGoods {

	/**
	 * 人员逻辑ID
	 */
	protected String personMagicId;
	/**
	 * 物品名称
	 */
	protected String belongingsName;
	/**
	 * 物品类型
	 */
	protected String belongingsType;
	/**
	 * 编号
	 */
	protected String numbering;
	/**
	 * 数量
	 */
	protected Integer quantity;
	/**
	 * 是否返还 Y返还  N不返还
	 */
	protected String isReturn;
	/**
	 * 单位
	 */
	protected String unit;
	/**
	 * 保管措施 staging-暂存 custody-代保管 seizure-扣押
	 */
	protected String measure;
	/**
	 * 保管柜号
	 */
	protected String cabinetNo;
	/**
	 * 图片URL
	 */
	protected String objectPicUrl;
	/**
	 * 物品备注
	 */
	protected String description;
	/**
	 * 领取方式 own_take-自己领回 entrust_take-委托领回 delay_take-延后领回;mail_take:邮寄领回;transfer_to_prison:移交监所
	 */
	protected String getWay;

	public void setPersonMagicId(String personMagicId){
		this.personMagicId = personMagicId;
	}

	public String getPersonMagicId(){
      return null == this.personMagicId ? null : this.personMagicId .trim();      
  }
	public void setBelongingsName(String belongingsName){
		this.belongingsName = belongingsName;
	}

	public String getBelongingsName(){
      return null == this.belongingsName ? null : this.belongingsName .trim();      
  }
	public void setBelongingsType(String belongingsType){
		this.belongingsType = belongingsType;
	}

	public String getBelongingsType(){
      return null == this.belongingsType ? null : this.belongingsType .trim();      
  }
	public void setNumbering(String numbering){
		this.numbering = numbering;
	}

	public String getNumbering(){
      return null == this.numbering ? null : this.numbering .trim();      
  }
	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}

	public Integer getQuantity(){
       return this.quantity;       
  }
	public void setIsReturn(String isReturn){
		this.isReturn = isReturn;
	}

	public String getIsReturn(){
      return null == this.isReturn ? null : this.isReturn .trim();      
  }
	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
      return null == this.unit ? null : this.unit .trim();      
  }
	public void setMeasure(String measure){
		this.measure = measure;
	}

	public String getMeasure(){
      return null == this.measure ? null : this.measure .trim();      
  }
	public void setCabinetNo(String cabinetNo){
		this.cabinetNo = cabinetNo;
	}

	public String getCabinetNo(){
      return null == this.cabinetNo ? null : this.cabinetNo .trim();      
  }
	public void setObjectPicUrl(String objectPicUrl){
		this.objectPicUrl = objectPicUrl;
	}

	public String getObjectPicUrl(){
      return null == this.objectPicUrl ? null : this.objectPicUrl .trim();      
  }
	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
      return null == this.description ? null : this.description .trim();      
  }
	public void setGetWay(String getWay){
		this.getWay = getWay;
	}

	public String getGetWay(){
      return null == this.getWay ? null : this.getWay .trim();      
  }
	/**
	 * @see Object#toString()
	 */

}
