package com.example.pages;

import java.util.LinkedList;
import java.util.List;

public class MenuView {

    private List<MenuItem> items = new LinkedList<>();


    public MenuView(List<MenuItem> items){
        this.items = items;
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
        sb.append("\n========================================\n");
        items.forEach(item -> sb.append(String.format("%s : %s\n ",item.cmd,item.description)));
        sb.append("========================================\n");
        return sb.toString();
    }

    public static class Builder{

        private List<MenuItem> items = new LinkedList<>();

        public Builder addItem(String cmd, String description) {
            this.items.add(new MenuItem(cmd,description));
            return this;
        }

        public MenuView build(){
            return new MenuView(items);
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
