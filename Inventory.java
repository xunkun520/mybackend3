import java.util.ArrayList;
import java.util.List;
public class Inventory {
    /* 3. Inventory.java
    属性：
    items（List<ItemStack>）：用于存放背包中所有的物品堆。
    capacity（int）：背包容量（格子总数），设为 36。
    方法（请补全实现）：
    addItem(ItemStack itemStackToAdd)
    实现向背包添加物品的完整逻辑（堆叠、找空格）。
    返回值：int，表示背包剩余容量，负数表示添加失败的物品数量。
    removeItem(String itemName, int amountToRemove)
    从背包中移除指定数量的某种物品。
    getItemCount(String itemName)
    统计背包中某种物品的总数量。
    display()
    在控制台清晰地打印出当前背包内所有物品及其数量。
     */
    private List<ItemStack> items = new ArrayList<>();
    private final int capacity = 36;
    public Inventory() {
        for (int i = 0; i < capacity; i++) {
            items.add(new ItemStack(null, 0));
        }
    }

    int overitemquantity = 0;
    String overitemname = "";
    int space=36;
    public int addItem(ItemStack itemStackToAdd) {
        overitemquantity = 0;
        overitemname = "";
        for (int i = 0; i < capacity; i++) {
            if(items.get(i).getItem()==null) {
                space++;
            }
        }
    if(itemStackToAdd.getQuantity()<=0){
        System.out.println("请输入正确的数量");
        return space;
    }
    if(itemStackToAdd.getItem().getMaxStackSize()<=0){
        System.out.println("最大堆叠数量必须大于0");
        return space;
    }
    for(ItemStack stack : items) {
        if (stack.getItem() == null) {
            continue;
        } else if (!stack.getItem().getName().equals(itemStackToAdd.getItem().getName())) {
            continue;
        } else {
            if (stack.getQuantity() + itemStackToAdd.getQuantity() <= itemStackToAdd.getItem().getMaxStackSize()) {
                stack.setQuantity(stack.getQuantity() + itemStackToAdd.getQuantity());
                stack.setItem(itemStackToAdd.getItem());
                itemStackToAdd.setQuantity(0);
                break;
            } else {
                itemStackToAdd.setQuantity(itemStackToAdd.getQuantity() - (itemStackToAdd.getItem().getMaxStackSize() - stack.getQuantity()));
                stack.setQuantity(itemStackToAdd.getItem().getMaxStackSize());
            }
        }
    }
        for(int j=0;j< items.size()&&itemStackToAdd.getQuantity()>0;j++){
           if(items.get(j).getItem()==null) {
               if(itemStackToAdd.getItem().getMaxStackSize()>=itemStackToAdd.getQuantity()){
                   items.get(j).setQuantity(itemStackToAdd.getQuantity());
                   items.get(j).setItem(itemStackToAdd.getItem());
                   itemStackToAdd.setQuantity(0);
               }else{
                   items.get(j).setQuantity(itemStackToAdd.getItem().getMaxStackSize());
                   items.get(j).setItem(itemStackToAdd.getItem());
                   itemStackToAdd.setQuantity(itemStackToAdd.getQuantity()-(itemStackToAdd.getItem().getMaxStackSize()));
               }
               space--;
           }
        }
        if (itemStackToAdd.getQuantity() > 0) {
            overitemname = itemStackToAdd.getItem().getName();
            overitemquantity = itemStackToAdd.getQuantity();

            return -itemStackToAdd.getQuantity();
        }

        return space;
    }
    public void removeItem(String itemName, int amountToRemove){
        for(int j=0;j<items.size();j++){
            if(items.get(j).getItem().getName().equals(itemName)){
                if(items.get(j).getQuantity()>=amountToRemove){
                    items.get(j).setQuantity(items.get(j).getQuantity()-amountToRemove);
                    amountToRemove = 0;
                }else{
                    amountToRemove = amountToRemove-items.get(j).getQuantity();
                   items.get(j).setItem(null);
                   items.get(j).setQuantity(0);
                }
            }
        }
        if(amountToRemove>0){
            System.out.println("抱歉，还有"+amountToRemove+"的"+itemName+"未删除");
        }else {
            System.out.println("已经删除所要求的全部");
        }
    }

        public void getItemCount (String itemName){
            int count = 0;
            for (int j = 0; j < items.size(); j++) {
                if (items.get(j).getItem().getName().equals(itemName)) {
                    count = count + items.get(j).getQuantity();
                }
            }
            int result = count;
            System.out.println(itemName + "有" + count + "个");
        }
    public void display() {
        int space = 0;
        for (int i = 0; i < items.size(); i++) {
            ItemStack check = items.get(i);
            if (check.getItem() == null) {
                System.out.print("格子" + (i + 1) + "：空"+"\t");
                space++;
                if((i+1)%6==0){
                    System.out.println();
                }
            } else {
                System.out.print("格子" +(i+1)+"："+ check.getItem().getName()+" × "+check.getQuantity()+"\t"
                );
                if((i+1)%6==0){
                    System.out.println();
                }
            }
        }
        System.out.println("剩余空格:"+space);
        if (overitemquantity > 0) {
            System.out.println("最近一次添加有" + overitemquantity + "个" + overitemname + "未能放入"
            );
        }
    }
    }
