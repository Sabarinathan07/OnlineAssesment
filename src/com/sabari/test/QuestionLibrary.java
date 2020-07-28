package com.sabari.test;

public class QuestionLibrary {
     String mQuestions [] = {
            "Which mahabharata character makes pandava to win the war?",
            "What is the other name of Karna?",
            "How many days kurukshetra war extends in mahabharata battle? ",
            "Whose death is very unfair in the kurukshetra war?",
            "What is the name of Duryodhan's wife?",
            "Who is the father of bheesmar?",
            "How Vichitravirya died in mahabharata?",
            "Which son of arjuna killed him in mahabharata?",
            "Who is son of Ghatotkacha in mahabhrata?",
            "How many sons did Ganga have in mahabharata?",
            "How many principal wives did Krishna have in mahabharata?",
            "Who is the wisest among pandavas?",
            "Who is the author of mahabharata?",
            "Select the other name of bheem among the choices.",
            "Who gave curse to the lord Krishna in mahabhrata?",
            "Which king was killed by bheem before yudhistir performed the rajasyua vagya?",
            "What was balarama's weapon? ",
            "How many children does Dhritarashta have?",
            "Who was in Arjuna's chariot except Krishna and Arjuna?",
            "Who cursed pandu?",
            "How many Dhirtarashta son's survived after the kurukshtra war?",
            "Who was also called as Pritha?",
            "Name the king Amba was secretly in love with him and promised to place the varmala on his neck.",
            "Daughter of Arjuna and Draupadi",
            "Name the Kingdom belongs to the princess Amba"
              };
    private String mChoices [][] = {
            {"Arjunan", "Krishnan", "Bheeman"},
            {"Radheya", "Partha", "Kriti"},
            {"20", "19", "18"},
            {"Karnan", "Dhuryodhanan", "Abhimanyu"},
            {"Indramathi", "Bhanumathi", "Bharathi"},
            {"Shantanu", "Vichitravirya", "Parakshith"},
            {"Heart attack", "Tuberculosis", "In a War"},
            {"Babruvahana", "Aravan", "Shrutkarma"},
            {"Chitrangada", "Barbarika", "Shrutkarma"},
            {"6", "10", "8"},
            {"5", "3", "8"},
            {"Sahadevan", "Yudhishthirar", "Arjunan"},
            {"Valmiki", "Vyasa", "Parashara"},
            {"Vikrodhara", "Sutasoma", "Susarma"},
            {"Duryodhanan", "Gandhari", "Dhritarashtra"},//15
            {"Jarasandh", "Sishupal", "Duryodhan"},
            {"Gada", "Plough", "Bow and Arrow"},
            {"101", "102", "100"},
            {"Shiva", "Hanuman", "Indra"},
            {"Rishi Durvasa", "Rishi Kindam", "Rishi Vashisth"},
            {"No one", "2", "1"},
            {"Pragati", "Kunti", "Satyavathi"},
            {"Kasha", "Sulaba", "Salva"},
            {"Pratigya", "Pragati", "Shyamala"},
            {"Kashi", "Barsana", "Mathura"}
            
            
    };



    private String mCorrectAnswers[] = {"Krishnan", "Radheya", "18", "Abhimanyu","Bhanumathi","Shantanu",
    		"Tuberculosis","Babruvahana","Barbarika","8","8","Sahadevan","Vyasa","Vikrodhara","Gandhari",
    		"Jarasandh","Plough","102","Hanuman","Rishi Kindam","1","Kunti","Salva",
    		"Pragati","Kashi"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}


