package com.kalachev.demonstration.questionlogic;

import java.util.Arrays;

public class Tester {

  public static void main(String[] args) {

    Question question = new Question("2+2");
    SuggestedAnswer answer1 = new SuggestedAnswer(question);
    answer1.setText("4");
    SuggestedAnswer answer2 = new SuggestedAnswer(question);
    answer2.setText("14");
    SuggestedAnswer answer3 = new SuggestedAnswer(question);
    answer3.setText("Green");

    Answer defaulAnswer = new Answer();
    defaulAnswer.setText("This Answer Is Not Optimal");
    question.setBestAnswer(defaulAnswer);
    question.setCandidateAnswers(Arrays.asList(answer1, answer2, answer3));

    System.out.println(
        "The question was               " + question.getQuestionText());
    System.out.println(
        "Its Answer was                " + question.getBestAnswer().getText());
    System.out
        .println("Other peoples suggested those answer for this question :");
    question.getCandidateAnswers().stream().map(Answer::getText)
        .forEach(System.out::println);
    System.out.println("right now it requers " + question.getVotesToBeChanged()
        + " votes to be changed");
    System.out.println();

    ////

    System.out.println("now we vote for other option ");
    for (int i = 0; i < 5; i++) {
      answer2.voteFor();
    }
    System.out.println("Let's see what has changed");
    System.out.println("The question is " + question.getQuestionText());
    System.out.println("Its Answer is " + question.getBestAnswer().getText());
    System.out
        .println("Other peoples suggested those answer for this question :");
    for (SuggestedAnswer answer : question.getCandidateAnswers()) {
      System.out.println(answer.getText() + "     and " + answer.getVotesCount()
          + " people voted for it");
    }
    System.out.println(
        "current amount of votes need to change Question's Answer is : "
            + question.getVotesToBeChanged());
    System.out.println("it show be 2 times more than before");
    System.out.println();

    /////////////

    System.out.println("lets vote again ");

    for (int i = 0; i < 8; i++) {
      answer1.voteFor();
      answer2.voteFor();
      answer3.voteFor();
    }
    answer1.voteFor();
    answer1.voteFor();
    System.out.println("Let's see what has changed");
    System.out.println("The question is " + question.getQuestionText());
    System.out.println("Its Answer is " + question.getBestAnswer().getText());
    System.out
        .println("Other peoples suggested those answer for this question :");
    for (SuggestedAnswer answer : question.getCandidateAnswers()) {
      System.out.println(answer.getText() + "     and " + answer.getVotesCount()
          + " people voted for it");
    }
    System.out.println(
        "current amount of votes need to change Question's Answer is : "
            + question.getVotesToBeChanged());
    System.out.println("it show be 2 times more than before");
    System.out.println();
  }
}
