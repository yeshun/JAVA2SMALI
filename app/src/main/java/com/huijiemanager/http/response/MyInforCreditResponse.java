package com.huijiemanager.http.response;

import java.util.ArrayList;

public class MyInforCreditResponse
{
  public ArrayList<InforDetail> c_list;
  public String p_name;
  
  public ArrayList<InforDetail> getC_list()
  {
    return this.c_list;
  }
  
  public String getP_name()
  {
    return this.p_name;
  }
  
  public void setC_list(ArrayList<InforDetail> paramArrayList)
  {
    this.c_list = paramArrayList;
  }
  
  public void setP_name(String paramString)
  {
    this.p_name = paramString;
  }
  
  public static class InforDetail
  {
    public boolean c_added;
    public String c_click;
    public String c_code;
    public String c_default;
    public boolean c_edit;
    public String c_index;
    public String c_name;
    public ArrayList<Option> c_option;
    public String c_title;
    public String c_type;
    public String c_value;
    public ArrayList<Hide> heidInfo;
    public boolean isOpen = true;
    
    public String getC_click()
    {
      return this.c_click;
    }
    
    public String getC_code()
    {
      return this.c_code;
    }
    
    public String getC_default()
    {
      return this.c_default;
    }
    
    public String getC_index()
    {
      return this.c_index;
    }
    
    public String getC_name()
    {
      return this.c_name;
    }
    
    public ArrayList<Option> getC_option()
    {
      return this.c_option;
    }
    
    public String getC_title()
    {
      return this.c_title;
    }
    
    public String getC_type()
    {
      return this.c_type;
    }
    
    public String getC_value()
    {
      return this.c_value;
    }
    
    public boolean isC_edit()
    {
      return this.c_edit;
    }
    
    public void setC_click(String paramString)
    {
      this.c_click = paramString;
    }
    
    public void setC_code(String paramString)
    {
      this.c_code = paramString;
    }
    
    public void setC_default(String paramString)
    {
      this.c_default = paramString;
    }
    
    public void setC_edit(boolean paramBoolean)
    {
      this.c_edit = paramBoolean;
    }
    
    public void setC_index(String paramString)
    {
      this.c_index = paramString;
    }
    
    public void setC_name(String paramString)
    {
      this.c_name = paramString;
    }
    
    public void setC_option(ArrayList<Option> paramArrayList)
    {
      this.c_option = paramArrayList;
    }
    
    public void setC_title(String paramString)
    {
      this.c_title = paramString;
    }
    
    public void setC_type(String paramString)
    {
      this.c_type = paramString;
    }
    
    public void setC_value(String paramString)
    {
      this.c_value = paramString;
    }
    
    public static class Hide
    {
      public String key;
      public String value;
      
      public String getKey()
      {
        return this.key;
      }
      
      public String getValue()
      {
        return this.value;
      }
      
      public void setKey(String paramString)
      {
        this.key = paramString;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public class Option
    {
      String op_code;
      String op_desc;
      
      public Option() {}
      
      public String getOp_code()
      {
        return this.op_code;
      }
      
      public String getOp_desc()
      {
        return this.op_desc;
      }
      
      public void setOp_code(String paramString)
      {
        this.op_code = paramString;
      }
      
      public void setOp_desc(String paramString)
      {
        this.op_desc = paramString;
      }
    }
  }
}


/* Location:              E:\apktool\dex2jar-2.0\xindaijia\classes_xindai2-dex2jar.jar!\com\huijiemanager\http\response\MyInforCreditResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */