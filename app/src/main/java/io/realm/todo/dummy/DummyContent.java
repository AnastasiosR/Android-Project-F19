package io.realm.todo.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        int temp = Integer.parseInt(String.valueOf(position));
        if(temp==1) {
            return new DummyItem(String.valueOf(position), "Coins: x10 ", makeDetails(position));
        }
        else if (temp==2){
            return new DummyItem(String.valueOf(position), "Coins: x20", makeDetails(position));
        }
        else if (temp==3) {
            return new DummyItem(String.valueOf(position), "Coins: x30 ", makeDetails(position));
        }
        else if(temp==4){
            return new DummyItem(String.valueOf(position), "Coins: x40 ", makeDetails(position));
        }
        return new DummyItem(String.valueOf(position), "Coins: x50 ", makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        String spaces = "\n \n \n";
        builder.append("Details about Item: ").append(position);
        if(position==0){
            builder.append("Position 0");
        }
        if(position==1){
            builder.append(spaces + "\n Receive 10 coins on your account.");
        }
        if(position==2){
            builder.append(spaces + "\n Receive 20 coins on your account.");
        }
        if(position==3){
            builder.append(spaces + "\n Receive 30 coins on your account.");
        }
        if(position==4) {
            builder.append(spaces + "\n Receive 40 coins on your account.");
        }
        if(position==5){
            builder.append(spaces +"\n Receive 50 coins on your account.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
