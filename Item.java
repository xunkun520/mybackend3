public class Item {
    /* 核心机制
    物品：每种物品都有自己的名字和最大堆叠数量（"石头"最多可以 64 个叠在一起，而"钻石剑"则无法堆叠，最大数量为 1）。
    物品堆：背包的每一个格子，存放的不是单个物品，而是一个"物品堆"，它包含了物品的种类和具体的数量。
    背包：背包拥有固定的容量，用于存放"物品堆"。
    添加逻辑：当向背包添加物品时，程序应执行以下操作：
    堆叠：优先寻找背包中已存在的、且未满的同类物品堆进行合并。
    放入空格：如果无法继续堆叠，则寻找一个空格子放入新的物品堆。
    处理溢出：如果背包已满，无法再放入，需要能告知有多少物品未能成功放入。
    任务要求
    你需要设计并实现以下几个核心类：
    1. Item.java
    属性：
    name（String）：物品名称，分别有三类物品，石头、木板、钻石剑。
    maxStackSize（int）：物品的最大堆叠数量，石头、木板、钻石剑的最大堆叠数量分别为 64、64、1。
     */
    private String name;
    private int maxStackSize;

    public Item(String name, int maxStackSize) {
        this.name = name;
        this.maxStackSize = maxStackSize;
    }

    public String getName() {
        return name;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxStackSize(int maxStackSize) {
        if (maxStackSize <= 0) {
            System.out.println("最大堆叠数量必须大于0");
        } else {
            this.maxStackSize = maxStackSize;
        }

    }
}

























}

