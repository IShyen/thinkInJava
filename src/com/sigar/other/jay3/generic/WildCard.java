package com.sigar.other.jay3.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型通配符测试类
 *
 * <? extends T> 表示类型的上界，表示参数化类型的可能是T 或是 T的子类
 * <? super T> 表示类型下界（Java Core中叫超类型限定），表示参数化类型是此类型的超类型（父类型），直至Object
 *
 */
public class WildCard {
    /**
     * 方法接收一个集合参数，遍历集合并把集合元素打印出来
     * 学习泛型之前的做法
     */
    public void test(List list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    /**
     * 方法接收一个集合参数，遍历集合并把集合元素打印出来
     * 学习了泛型之后的做法
     *
     * 该方法只能遍历装载着Object的集合！！！
     *
     * 强调：泛型中的<Object>并不是像以前那样有继承关系的，也就是说List<Object>和List<String>是毫无关系的！！！！
     */
    public void test2(List<Object> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    /**
     * 方法接收一个集合参数，遍历集合并把集合元素打印出来
     * 学习了类型通配符之后的做法
     *
     * 当我们使用?号通配符的时候：就只能调对象与类型无关的方法，不能调用对象与类型有关的方法。
     *
     * 下面的List集合，我是不能使用add()方法的。因为add()方法是把对象丢进集合中，而现在我是不知道对象的类型是什么。
     */
    public void test3(List<?> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    /**
     * 大多时候，我们都可以使用泛型方法来代替通配符
     *
     * 如果参数之间的类型有依赖关系，或者返回值是与参数之间有依赖关系的。那么就使用泛型方法
     * 如果没有依赖关系的，就使用通配符，通配符会灵活一些.
     */
    public static void test11(List<?> list) {
        //使用通配符
    }

    public <T> void  test12(List<T> t) {
        //使用泛型方法
    }

    /**
     * List<? extends Frut> 表示 “具有任何从Fruit继承类型的列表”，编译器无法确定List所持有的类型，所以无法安全的向其中添加对象。
     * 可以添加null,因为null 可以表示任何类型。所以List 的add 方法不能添加任何有意义的元素，但是可以接受现有的子类型List<Apple> 赋值。
     * @param args
     */
    public static void main(String[] args){
        /**
         * 我们可以把它读作：一个类型的 List， 这个类型可以是继承了 Fruit 的某种类型。
         * 注意，这并不是说这个 List 可以持有 Fruit 的任意类型。通配符代表了一种特定的类型，它表示 “某种特定的类型，但是 flist 没有指定”。
         */
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // complie error:
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null); // only work for null

        Fruit fruit = flist.get(0);
        Apple apple = (Apple)flist.get(0);

        //由于，其中放置是从Fruit中继承的类型，所以可以安全地取出Fruit类型。
        flist.contains(new Fruit());
        flist.contains(new Apple());


        /**
         * extends 可用于返回类型限定，不能用于参数类型限定。
         * super 可用于参数类型限定，不能用于返回类型限定。
         * 带有super超类型限定的通配符可以向泛型对象写入，带有extends子类型限定的通配符可以向泛型对象读取。
         */
        List<? super Fruit> flist2 = new ArrayList<Fruit>();
        flist2.add(new Fruit());
        flist2.add(new Apple());
        flist2.add(new RedApple());
    }
}
