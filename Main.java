public class Main {
    /*请你编写一个 main 函数来驱动和测试你的代码，模拟以下场景：
    创建一个容量为 36 的背包。
    添加物品：向背包中添加 30 个"石头"。
    测试堆叠：再次向背包中添加 40 个"石头"。（预期：背包里应有一个 64 个的石头堆和一个 6 个的石头堆）。
    添加不可堆叠物品：向背包中添加 1 把"钻石剑"。
    测试溢出：尝试向背包中添加 35 个"木板"堆，每个堆包含 64 个木板。（预期：填满剩余格子后，会有物品添加失败）。
    移除物品：从背包中移除 10 个"石头"。（预期：64 的石头堆变为 54）。
    背包展示：在以上每次操作后调用 display() 方法，展示背包的状态。
    将整个项目打包成一个可执行的 JAR 文件，通过命令行 java -jar your-app.jar 来直接运行你的程序
     */
    public static void main(String[] args) {
        Item stone = new Item("石头", 64);
        Item plank = new Item("木板", 64);
        Item sword = new Item("钻石剑", 1);
        Inventory inventory = new Inventory();
        System.out.println("添加30个石头");
        inventory.addItem(new ItemStack(stone, 30));
        inventory.display();
        System.out.println("再添加40个石头");
        inventory.addItem(new ItemStack(stone, 40));
        inventory.display();
        System.out.println("添加35堆木板，每堆64个");
        for(int i=1;i<=35;i++){
            inventory.addItem(new ItemStack(plank,64));
        }
        inventory.display();
        System.out.println("添加1把钻石剑");
        inventory.addItem(new ItemStack(sword, 1));
        inventory.display();
        System.out.println("移除10个石头");
        inventory.removeItem("石头",10);
        inventory.display();
        System.out.println("移除640个木板");
        inventory.removeItem("木板",640);
        inventory.display();

    }
}

