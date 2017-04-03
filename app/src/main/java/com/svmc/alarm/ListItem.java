package com.svmc.alarm;

/**
 * Created by sev_user on 3/9/2017.
 */

public class ListItem
{
    String label;
    String name;
    String edit;
    boolean checkbox;
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public  ListItem(String label, String name){
        super();
        this.label = label;
        this.name = name;
    }
    public ListItem(String edit)
    {
        super();
        this.edit = edit;
    }
    public ListItem (String label,boolean checkbox){
        super();
        this.label = label;
        this.checkbox = checkbox;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public String isEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
