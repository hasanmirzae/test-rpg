package com.example.pages;

import java.util.LinkedList;
import java.util.List;


/*
 * A convenient class to show the menus.
 */
public class MenuView {

    private List<MenuItem> items = new LinkedList<>();
    private String title;


    public MenuView(List<MenuItem> items){
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void addItem(String cmd, String description) {
        this.items.add(new MenuItem(cmd,description));
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n**************************************");
        sb.append("\n            "+title);
        sb.append("\n**************************************");
        items.forEach(item -> sb.append(String.format("\n%s : %s\n",item.cmd,item.description)));
        sb.append("--------------------------------------\n");
        return sb.toString();
    }

    public static class Builder{

        private List<MenuItem> items = new LinkedList<>();
        private String title;

        public Builder addItem(String cmd, String description) {
            this.items.add(new MenuItem(cmd,description));
            return this;
        }

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public MenuView build(){
            MenuView instance = new MenuView(items);
            instance.setTitle(title);
            return instance;
        }
    }


    public static class MenuItem{
        public String cmd;
        public String description;

        public MenuItem(String cmd, String description) {
            this.cmd = cmd;
            this.description = description;
        }
    }
}
