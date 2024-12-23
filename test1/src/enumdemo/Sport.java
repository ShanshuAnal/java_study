package enumdemo;

/**
 * @Author: 19599
 * @Date: 2024/12/9 16:21
 */
public enum Sport implements Enjoyable{
    TENNIS("乒乓球", 2) {
        @Override
        public void enjoy() {
            System.out.println("打乒乓球太爽了");
        }

        @Override
        public void run() {
            System.out.println("乒乓球开打");
        }
    },
    BASKETBALL("篮球", 10) {
        @Override
        public void enjoy() {
            System.out.println("打篮球太爽了");
        }

        @Override
        public void run() {
            System.out.println("篮球开打");
        }
    },
    FOOTBALL("足球", 22) {
        @Override
        public void run() {
            System.out.println("足球开打");
        }
    },
    SWIMMING("游泳", 10) {
        @Override
        public void run() {
            System.out.println("游泳开打");
        }
    };

    private String name;
    private int num;

    Sport(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public void enjoy() {
        System.out.println(name + "太爽啦");
    }

    public abstract void run();

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }
}
