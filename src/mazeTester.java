public class mazeTester {
    public static void main(String[] args) {

        try {
            MazeNavigator[] mazeNavigators = {new MazeNavigator(1, "src/PlayerOneMoves.txt"),
                    new MazeNavigator(2, "src/PlayerTwoMoves.txt")};
            /*
            定义 mazeNavigator 数组; 有两个成员变量 (元素); (new: 只有是新的才能申请存放；变成object)
            附两个初值
            new MazeNavigator 是前面创建的class；playerNumber and fileName是前面constructor创建的内容
            is a simplified version of:
            MazeNavigator[] mazeNavigators;
            MazeNavigator[] mazeNavigators;
            MazeNavigator a,b;
            a=new MazeNavigator(1, "src/PlayerOneMoves.txt");
            b=new MazeNavigator(2, "src/PlayerTwoMoves.txt");
            mazeNavigators[0]=a;
            mazeNavigators[1]=b;
            */

            //执行mazeNavigators, 只有两个元素 1， 2
            // i=0 是 1 ； i=1 是 2
            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].start(); //mazeNavigators[i] 是前面class定义的object
            } //start 启动 run方法(function)；run可以跑很多次，start一次

            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

