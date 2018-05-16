package com.huijiemanager.http.response;

import java.io.Serializable;

public class QuareOrderTagsResponse
        implements Serializable
{
    private int id;
    private String logo;
    private String name;
    private boolean show_image;

    public int getId()
    {
        return this.id;
    }

    public String getLogo()
    {
        return this.logo;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getShow_image()
    {
        return this.show_image;
    }

    public void setId(int paramInt)
    {
        this.id = paramInt;
    }

    public void setLogo(String paramString)
    {
        this.logo = paramString;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }

    public void setShow_image(boolean paramBoolean)
    {
        this.show_image = paramBoolean;
    }
}