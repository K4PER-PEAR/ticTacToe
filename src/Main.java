//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    ticTacToe a = new ticTacToe();
    String currentTurn = "player";
    Random rand = new Random();
    a.printGameBoard();



    while(true) {
        Scanner scanInput = new Scanner(System.in);
        IO.println("Enter the number to place mark (1-9): ");
        int playerPos = scanInput.nextInt();
        String conflict = a.checkConflict(playerPos);
        while(!conflict.isEmpty())
        {
            IO.println(conflict);
            playerPos = scanInput.nextInt();
            conflict = a.checkConflict(playerPos);
        }


        a.updateGameBoard(playerPos,currentTurn);
        currentTurn = "cpu";

        String result = a.checkWinner();
        if(!result.isEmpty()) {
            a.printGameBoard();
            IO.println(result);
            break;
        }

        int cpuPos = rand.nextInt(9)+1;
        conflict = a.checkConflict(cpuPos);
        while(!conflict.isEmpty())
        {
            //IO.println(conflict);
            cpuPos = rand.nextInt(9)+1;
            conflict = a.checkConflict(cpuPos);
        }
        a.updateGameBoard(cpuPos,currentTurn);
        a.printGameBoard();
        currentTurn = "player";

        result = a.checkWinner();
        if(!result.isEmpty()) {
            IO.println(result);
            break;
        }

    }




}
