package com.huijiemanager.http.response;

import java.util.List;

public class QuareOrderFiltrateResponse
{
  private List<BannersBean> banners;
  private List<OrdersBean> orders;
  
  public List<BannersBean> getBanners()
  {
    return this.banners;
  }
  
  public List<OrdersBean> getOrders()
  {
    return this.orders;
  }
  
  public void setBanners(List<BannersBean> paramList)
  {
    this.banners = paramList;
  }
  
  public void setOrders(List<OrdersBean> paramList)
  {
    this.orders = paramList;
  }
  
  public static class BannersBean
  {
    private int id;
    private String image0;
    private String name;
    private int sort;
    private int target_type;
    private String target_url;
    private String target_url_schema;
    
    public int getId()
    {
      return this.id;
    }
    
    public String getImage0()
    {
      return this.image0;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public int getSort()
    {
      return this.sort;
    }
    
    public int getTarget_type()
    {
      return this.target_type;
    }
    
    public String getTarget_url()
    {
      return this.target_url;
    }
    
    public String getTarget_url_schema()
    {
      return this.target_url_schema;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setImage0(String paramString)
    {
      this.image0 = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setSort(int paramInt)
    {
      this.sort = paramInt;
    }
    
    public void setTarget_type(int paramInt)
    {
      this.target_type = paramInt;
    }
    
    public void setTarget_url(String paramString)
    {
      this.target_url = paramString;
    }
    
    public void setTarget_url_schema(String paramString)
    {
      this.target_url_schema = paramString;
    }
  }
  
  public static class OrdersBean
  {
    private String assetsInfo;
    private String canCollect;
    private String city;
    private String createTime;
    private boolean curHasCollected;
    private boolean curHasScan;
    private int cycleTime;
    private String discount;
    private String displayTags;
    private String district;
    private int howManyPeopleHasCollected;
    private int howManyPeopleHasScan;
    private int id;
    private String incomeInfo;
    private String jobIdentityUrl;
    private String loanPurpose;
    private int loanStatus;
    private String loanStatusDesc;
    private String loan_amount;
    private String locationInfo;
    private String orderStar;
    private String orderType;
    private String province;
    private List<String> tags;
    private String[] thirdCertifyImageUrl;
    private String updateTime;
    private UserCreditInfoBean userCreditInfo;
    private String userDesc;
    private String userId;
    private String userLogoUrl;
    private int verifiedZhiMa;
    private int zhiMaScore;
    private String zhiMaUrl;
    private String zhimaRank;
    private String zhongAnDescription;
    private String zhongAnLevel;
    
    public String getAssetsInfo()
    {
      return this.assetsInfo;
    }
    
    public String getCanCollect()
    {
      return this.canCollect;
    }
    
    public String getCity()
    {
      return this.city;
    }
    
    public String getCreateTime()
    {
      return this.createTime;
    }
    
    public int getCycleTime()
    {
      return this.cycleTime;
    }
    
    public String getDiscount()
    {
      return this.discount;
    }
    
    public String getDisplayTags()
    {
      return this.displayTags;
    }
    
    public String getDistrict()
    {
      return this.district;
    }
    
    public int getHowManyPeopleHasCollected()
    {
      return this.howManyPeopleHasCollected;
    }
    
    public int getHowManyPeopleHasScan()
    {
      return this.howManyPeopleHasScan;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getIncomeInfo()
    {
      return this.incomeInfo;
    }
    
    public String getJobIdentityUrl()
    {
      return this.jobIdentityUrl;
    }
    
    public String getLoanPurpose()
    {
      return this.loanPurpose;
    }
    
    public int getLoanStatus()
    {
      return this.loanStatus;
    }
    
    public String getLoanStatusDesc()
    {
      return this.loanStatusDesc;
    }
    
    public String getLoan_amount()
    {
      return this.loan_amount;
    }
    
    public String getLocationInfo()
    {
      return this.locationInfo;
    }
    
    public String getOrderStar()
    {
      return this.orderStar;
    }
    
    public String getOrderType()
    {
      return this.orderType;
    }
    
    public String getProvince()
    {
      return this.province;
    }
    
    public List<String> getTags()
    {
      return this.tags;
    }
    
    public String[] getThirdCertifyImageUrl()
    {
      return this.thirdCertifyImageUrl;
    }
    
    public String getUpdateTime()
    {
      return this.updateTime;
    }
    
    public UserCreditInfoBean getUserCreditInfo()
    {
      return this.userCreditInfo;
    }
    
    public String getUserDesc()
    {
      return this.userDesc;
    }
    
    public String getUserId()
    {
      return this.userId;
    }
    
    public String getUserLogoUrl()
    {
      return this.userLogoUrl;
    }
    
    public int getVerifiedZhiMa()
    {
      return this.verifiedZhiMa;
    }
    
    public int getZhiMaScore()
    {
      return this.zhiMaScore;
    }
    
    public String getZhiMaUrl()
    {
      return this.zhiMaUrl;
    }
    
    public String getZhimaRank()
    {
      return this.zhimaRank;
    }
    
    public String getZhongAnDescription()
    {
      return this.zhongAnDescription;
    }
    
    public String getZhongAnLevel()
    {
      return this.zhongAnLevel;
    }
    
    public boolean isCurHasCollected()
    {
      return this.curHasCollected;
    }
    
    public boolean isCurHasScan()
    {
      return this.curHasScan;
    }
    
    public void setAssetsInfo(String paramString)
    {
      this.assetsInfo = paramString;
    }
    
    public void setCanCollect(String paramString)
    {
      this.canCollect = paramString;
    }
    
    public void setCity(String paramString)
    {
      this.city = paramString;
    }
    
    public void setCreateTime(String paramString)
    {
      this.createTime = paramString;
    }
    
    public void setCurHasCollected(boolean paramBoolean)
    {
      this.curHasCollected = paramBoolean;
    }
    
    public void setCurHasScan(boolean paramBoolean)
    {
      this.curHasScan = paramBoolean;
    }
    
    public void setCycleTime(int paramInt)
    {
      this.cycleTime = paramInt;
    }
    
    public void setDiscount(String paramString)
    {
      this.discount = paramString;
    }
    
    public void setDisplayTags(String paramString)
    {
      this.displayTags = paramString;
    }
    
    public void setDistrict(String paramString)
    {
      this.district = paramString;
    }
    
    public void setHowManyPeopleHasCollected(int paramInt)
    {
      this.howManyPeopleHasCollected = paramInt;
    }
    
    public void setHowManyPeopleHasScan(int paramInt)
    {
      this.howManyPeopleHasScan = paramInt;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setIncomeInfo(String paramString)
    {
      this.incomeInfo = paramString;
    }
    
    public void setJobIdentityUrl(String paramString)
    {
      this.jobIdentityUrl = paramString;
    }
    
    public void setLoanPurpose(String paramString)
    {
      this.loanPurpose = paramString;
    }
    
    public void setLoanStatus(int paramInt)
    {
      this.loanStatus = paramInt;
    }
    
    public void setLoanStatusDesc(String paramString)
    {
      this.loanStatusDesc = paramString;
    }
    
    public void setLoan_amount(String paramString)
    {
      this.loan_amount = paramString;
    }
    
    public void setLocationInfo(String paramString)
    {
      this.locationInfo = paramString;
    }
    
    public void setOrderStar(String paramString)
    {
      this.orderStar = paramString;
    }
    
    public void setOrderType(String paramString)
    {
      this.orderType = paramString;
    }
    
    public void setProvince(String paramString)
    {
      this.province = paramString;
    }
    
    public void setTags(List<String> paramList)
    {
      this.tags = paramList;
    }
    
    public void setThirdCertifyImageUrl(String[] paramArrayOfString)
    {
      this.thirdCertifyImageUrl = paramArrayOfString;
    }
    
    public void setUpdateTime(String paramString)
    {
      this.updateTime = paramString;
    }
    
    public void setUserCreditInfo(UserCreditInfoBean paramUserCreditInfoBean)
    {
      this.userCreditInfo = paramUserCreditInfoBean;
    }
    
    public void setUserDesc(String paramString)
    {
      this.userDesc = paramString;
    }
    
    public void setUserId(String paramString)
    {
      this.userId = paramString;
    }
    
    public void setUserLogoUrl(String paramString)
    {
      this.userLogoUrl = paramString;
    }
    
    public void setVerifiedZhiMa(int paramInt)
    {
      this.verifiedZhiMa = paramInt;
    }
    
    public void setZhiMaScore(int paramInt)
    {
      this.zhiMaScore = paramInt;
    }
    
    public void setZhiMaUrl(String paramString)
    {
      this.zhiMaUrl = paramString;
    }
    
    public void setZhimaRank(String paramString)
    {
      this.zhimaRank = paramString;
    }
    
    public void setZhongAnDescription(String paramString)
    {
      this.zhongAnDescription = paramString;
    }
    
    public void setZhongAnLevel(String paramString)
    {
      this.zhongAnLevel = paramString;
    }
    
    public static class UserCreditInfoBean
    {
      private String house;
      
      public String getHouse()
      {
        return this.house;
      }
      
      public void setHouse(String paramString)
      {
        this.house = paramString;
      }
    }
  }
}


/* Location:              E:\apktool\dex2jar-2.0\xindaijia\classes_xindai2-dex2jar.jar!\com\huijiemanager\http\response\QuareOrderFiltrateResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */