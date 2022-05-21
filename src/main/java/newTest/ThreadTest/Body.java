package newTest.ThreadTest;

/**
 * @program: mybatisPlusdemo
 * @description:    测试内部类调用
 * @author: hzl
 * @create: 2022-05-19 20:20
 **/

public class Body { //外部类

    public class Heart{ //成员内部类
        public void methodHeart(){
            System.out.println("这是一个内部类方法");

            //内部类可以随意访问外部类
            System.out.println("我的名字是 " + name);
        }
    }

    private String name = "zhangsan";

    public void methodBody(){
        System.out.println("这是一个外部类方法");
        Heart heart = new Heart();
        heart.methodHeart();    //外部类调用内部类方法，必须创建内部类对象进行调用
    }

}


