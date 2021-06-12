package android.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btn:Array<Array<Button>>     //declare 2d button array
    var playerX= true      //true if playerX turn else flase
    var count=0            //count the no of turns

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arr= Array(3){ IntArray(3)}  // to give initial values
        //initialize 2d array of btn with id/variable buttons
        btn= arrayOf(
            arrayOf(button1,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )
        //for initial values of buttons
        fun initials() {
            for(i in 0..2)
                for(j in 0..2) {
                    arr[i][j]=-1
                    btn[i][j].text=""
                    btn[i][j].isEnabled=true
                    tvTurn.text="Player X Turn!!"
                    playerX=true
                    count=0
                }
        }
        // function to disable button if winner is found
        fun btnDisable() {
            for(i in 0..2)
                for (j in 0..2)
                    btn[i][j].isEnabled=false;
        }
        //function to check the winner
        fun win(finalBtn:Button):Boolean {
            //for row winner
            for (i in 0..2) {
                if (arr[i][0] == 1 && arr[i][1] == 1 && arr[i][2] == 1) {
                    tvTurn.text = "WINNER - Player X"
                    finalBtn.text="X"
                    btnDisable()
                    return true
                }
                else if (arr[i][0] == 2 && arr[i][1] == 2 && arr[i][2] == 2) {
                    tvTurn.text = "WINNER - Player O"
                    finalBtn.text="O"
                    btnDisable()
                    return true
                }
            }
            //for column winner
            for (j in 0..2) {
                if (arr[0][j] == 1 && arr[1][j] == 1 && arr[2][j] == 1) {
                    tvTurn.text = "WINNER - Player X"
                    finalBtn.text="X"
                    btnDisable()
                    return true
                }
                else if (arr[0][j] == 2 && arr[1][j] == 2 && arr[2][j] == 2) {
                    tvTurn.text = "WINNER - Player O"
                    finalBtn.text="O"
                    btnDisable()
                    return true
                }
            }
            // for diagonal winner
            if ((arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) || arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1) {
                tvTurn.text = "WINNER - Player X"
                finalBtn.text="X"
                btnDisable()
                return true
            }
            else if ((arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2) || arr[0][2] == 2 && arr[1][1] == 2 && arr[2][0] == 2) {
                tvTurn.text = "WINNER - Player O"
                finalBtn.text="O"
                btnDisable()
                return true
            }
            return false
        }
        // function to see whose turn is
        fun turn(b:Button){
            if(playerX) {
                tvTurn.text="Player O Turn!!"
                b.text="X"
                playerX=false
            }
            else  {
                tvTurn.text="Player X turn!!"
                b.text="O"
                playerX=true
            }
            b.isEnabled=false
        }
        // setting on click listener on every button
        for(i in btn) {
            for (bt in i) {
                bt.setOnClickListener {
                    when(it.id){
                        R.id.button1-> {
                            if (playerX) arr[0][0]=1
                            else arr[0][0]=2
                            if(!win(button1)) {
                            count++
                            turn(button1)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                        R.id.button2-> {
                            if (playerX) arr[0][1]=1
                            else arr[0][1]=2
                            if(!win(button2)) {
                            count++
                            turn(button2)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                        R.id.button3-> {
                            if (playerX) arr[0][2]=1
                            else arr[0][2]=2
                            if(!win(button3)) {
                            count++
                            turn(button3)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                        R.id.button4-> {
                            if (playerX) arr[1][0]=1
                            else arr[1][0]=2
                            if(!win(button4)) {
                            count++
                            turn(button4)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                        R.id.button5-> {
                            if (playerX) arr[1][1]=1
                            else arr[1][1]=2
                            if(!win(button5)) {
                            count++
                            turn(button5)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                        R.id.button6-> {
                            if (playerX) arr[1][2]=1
                            else arr[1][2]=2
                            if(!win(button6)) {
                            count++
                            turn(button6)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                        R.id.button7-> {
                            if (playerX) arr[2][0]=1
                            else arr[2][0]=2
                            if(!win(button7)) {
                            count++
                            turn(button7)
                            if(count==9) tvTurn.text="Match Draw!!"}
                        }
                        R.id.button8-> {
                            if (playerX) arr[2][1]=1
                            else arr[2][1]=2
                            if(!win(button8)) {
                            count++
                            turn(button8)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                        R.id.button9-> {
                            if (playerX) arr[2][2]=1
                            else arr[2][2]=2
                            if(!win(button9)) {
                            count++
                            turn(button9)
                            if(count==9) tvTurn.text="Match Draw!!" }
                        }
                    }
                }
            }
        }
        btnReset.setOnClickListener{
            initials()
        }
    }
}