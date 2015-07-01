package com.example.alvin.histora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.ArrayList;


public class QuizActivity extends ActionBarActivity {

    ArrayList<QuizTopic> mQuizTopicList = new ArrayList();
    int mTopicID;
    TextView mQuestion1;
    TextView mQuestion2;
    TextView mQuestion3;
    TextView mQuestion4;
    TextView mQuestion5;
    RadioGroup mGroup1;
    RadioGroup mGroup2;
    RadioGroup mGroup3;
    RadioGroup mGroup4;
    RadioGroup mGroup5;
    EditText mUserNameField;
    Button mSubmitButton;
    String mAnswer1;
    String mAnswer2;
    String mAnswer3;
    String mAnswer4;
    String mAnswer5;
    String mUserName;
    int mScore;
//    public static final String USER_ID_KEY = "userId";
//    private static String sUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        mTopicID = intent.getIntExtra("Topic", 0);

        mScore = 0;

        //Quiz questions and answers here
        //Pre-Raffles
        mQuizTopicList.add(new QuizTopic(new String[] {"Ptolemy was Greco-Roman", "The earliest written record of Singapore was from the 2nd century", "The earliest written record of Singapore described it as the island of Pu Luo Chung", "Sang Nila Utama landed in Singapore during the 13th Century", "Singapore was originally named Singapura, which means 'Tiger City'"},
                                         new String[] {"True", "False", "True", "True", "False"}));
        //Founding of Modern Singapore
        mQuizTopicList.add(new QuizTopic(new String[] {"Sir Stamford Raffles arrived in Singapore on 28 January 1818", "Raffles saw potential in Singapore as it had a deep harbour, fresh water supplies and timber", "When Raffles arrived, he found a small Indian settlement on the island", "When Raffles arrived, Singapore was under the rule of Temenggong Abdu'r Rahman", "The British got permission to establish a trading port at Singapore in exchange for helping reinstate Tengku Hussein "},
                new String[] {"False", "True", "False", "True", "True"}));
        //Early Growth
        mQuizTopicList.add(new QuizTopic(new String[] {"Raffles left Major William Farquhar in charge of Singapore while he returned to Bencoolen", "Singapore's revenue came largely from collecting port duties", "Singapore had surpassed Penang in trade volume by 1825", "Raffles disagreed with Major Farquhar's administrative decisions", "Raffles oragnized Singapore into ethnic subdivisions"},
                new String[] {"True", "False", "True", "True", "True"}));
        //Straits Settlements
        mQuizTopicList.add(new QuizTopic(new String[] {"The Dutch protested the British establishment of Singapore", "As part of the Anglo-Dutch Treaty of 1824, the area north of the Straits of Malacca fell under Britain's sphere of influence", "Singapore was grouped with Penang and Malacca to form the Straits Settlements in 1827", "Singapore was attractive as it was a free port", "Administrators in Singapore were usually unfamiliar with local customs during this period"},
                new String[] {"True", "True", "False", "True", "True"}));
        //Straits Settlements Crown Colony
        mQuizTopicList.add(new QuizTopic(new String[] {"The Straits Settlements became a British Crown Colony because of the inadequacy of the administration at the time ", "The Chinese Protectorate was established in 1872 to help meet the needs of the Chinese community", "Singapore became a crown colony in 1887 ", "The Chinese Secret Societies were a big problem by the time Singapore became a Crown Colony", "There was no fleet stationed at Singapore because the British had no more money after spending all of it on the base"},
                new String[] {"True", "False", "False", "True", "False"}));
        //Battle for Singapore and Occupation
        mQuizTopicList.add(new QuizTopic(new String[] {"Japanese forced first landed in Malaya on 8 December 1941 ", "3 days prior to their landing the British had suffered their worst naval defeat of World War II", "Malaya had falled within 55 days", "The causeway linking Singapore with the rest of Malaya was blown up in an attempt to stop the Japanese", "Singapore fell 1 day after Valentine's Day"},
                new String[] {"True", "False", "True", "True", "True"}));
        //Postwar Period
        mQuizTopicList.add(new QuizTopic(new String[] {"Singapore was very unstable after the Japanese surrender ", "Singapore was governed by a military administration for 5 years", "Most of the infrastructure had remained intact for Japanese use during the war", "There was a shortage of food in the immediate postwar years ", "The economy began to recover as a result of increasing demand for tin and rubber around the world "},
                new String[] {"True", "False", "False", "True", "True"}));
        //Self-Governance
        mQuizTopicList.add(new QuizTopic(new String[] {"Lee Kuan Yew was the first Chief Minister of Singapore", "The Hock Lee Bus Riots broke out in 1957", "British concern over the communist threat was a reason why they did not want to grant Singapore full self-governance ", "The People's Action Party (PAP) got voted in in 1960 ", "The PAP believed that Singapore's future lay with Malaya"},
                new String[] {"False", "False", "True", "False", "True"}));
        //Merger
        mQuizTopicList.add(new QuizTopic(new String[] {"The newly formed country of Malaysia granted special priveleges to Malays, leading to unahppiness among the Chinese", "Singaporean political leaders campaigned for equality, claiming to be for a \"Malaysian Malaysia\"", "A race riot took place on 21 July 1963, Prophet Muhammad's birthday", "Singapore was made independent on 9 August 1965 after the Parliament of Malaysia voted 126-0 in favour of expelling Singapore", "Yusof bin Ishak was appointed the first President of Singapore"},
                new String[] {"True", "True", "False", "True", "True"}));
        //Independence
        mQuizTopicList.add(new QuizTopic(new String[] {"A lack of natural resources was a challenge faced by Singapore in its development", "National Service was established right after independence in 1965 to aid in defense", "Goh Chok Tong took office in 1995 ", "Lee Kuan Yew was the first prime minister of Singapore ", "Lee Hsien Loong took office in 2004 "},
                new String[] {"True", "False", "False", "True", "True"}));

        //Getting questions and answers
        mQuestion1 = (TextView) findViewById(R.id.question_1);
        mQuestion1.setText(mQuizTopicList.get(mTopicID).getQuestions()[0]);

        mQuestion2 = (TextView) findViewById(R.id.question_2);
        mQuestion2.setText(mQuizTopicList.get(mTopicID).getQuestions()[1]);

        mQuestion3 = (TextView) findViewById(R.id.question_3);
        mQuestion3.setText(mQuizTopicList.get(mTopicID).getQuestions()[2]);

        mQuestion4 = (TextView) findViewById(R.id.question_4);
        mQuestion4.setText(mQuizTopicList.get(mTopicID).getQuestions()[3]);

        mQuestion5 = (TextView) findViewById(R.id.question_5);
        mQuestion5.setText(mQuizTopicList.get(mTopicID).getQuestions()[4]);

        mSubmitButton = (Button) findViewById(R.id.quiz_submit_button);

        mGroup1 = (RadioGroup) findViewById(R.id.answer1);
        mGroup2 = (RadioGroup) findViewById(R.id.answer2);
        mGroup3 = (RadioGroup) findViewById(R.id.answer3);
        mGroup4 = (RadioGroup) findViewById(R.id.answer4);
        mGroup5 = (RadioGroup) findViewById(R.id.answer5);

        mUserNameField = (EditText) findViewById(R.id.quiz_username_field);

        //the score should be calculated inside the app
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAnswer1 = ((RadioButton) findViewById(mGroup1.getCheckedRadioButtonId())).getText().toString();
                mAnswer2 = ((RadioButton) findViewById(mGroup2.getCheckedRadioButtonId())).getText().toString();
                mAnswer3 = ((RadioButton) findViewById(mGroup3.getCheckedRadioButtonId())).getText().toString();
                mAnswer4 = ((RadioButton) findViewById(mGroup4.getCheckedRadioButtonId())).getText().toString();
                mAnswer5 = ((RadioButton) findViewById(mGroup5.getCheckedRadioButtonId())).getText().toString();

                mUserName = mUserNameField.getText().toString();

                String[] mAnswerArray = {mAnswer1, mAnswer2, mAnswer3, mAnswer4, mAnswer5};

                for (int i=0; i<5; i++){

                String givenAnswer = mAnswerArray[i];
                String correctAnswer = mQuizTopicList.get(mTopicID).getAnswers()[i];

                    if (givenAnswer == correctAnswer){
                        mScore++;
                    }
                }
                    /*
                    ParseObject score=new ParseObject("score");
                    score.put(USER_ID_KEY,sUserId);
                    score.put("score",mScore);
                        score.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                Toast toast = Toast.makeText(QuizActivity.this, "Successfully saved score" + mAnswer1,
                                        Toast.LENGTH_SHORT);
                                toast.show();
                            }
                    });
                    */

                ParseObject gameScore = new ParseObject("GameScore");
                gameScore.put("score", mScore);
                gameScore.put("playerName", mUserName);
                gameScore.saveInBackground();

                Intent intent = new Intent(QuizActivity.this, ScorePageActivity.class);
                intent.putExtra("score", mScore);
                startActivity(intent);
            }
        });
    }
//    private void startWithCurrentUser() {
//        sUserId = ParseUser.getCurrentUser().getObjectId();    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
