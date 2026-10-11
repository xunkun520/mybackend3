public class ItemStack {
           /*  2. ItemStack.java
    属性：
    item（Item）：物品的类型。
    quantity（int）：当前堆叠的数量。
            */
    private Item item;
    private int quantity;
    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setItem(Item  item) {
        this.item = item;
    }
}
