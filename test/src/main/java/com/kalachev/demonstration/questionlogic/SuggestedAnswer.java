package com.kalachev.demonstration.questionlogic;

import java.util.List;

public class SuggestedAnswer extends Answer {

  private final Question myQuestion;
  private int votesCount;

  public SuggestedAnswer(Question myQuestion) {
    super();
    this.myQuestion = myQuestion;
    this.votesCount = 0;
  }

  public Question getMyQuestion() {
    return myQuestion;
  }

  public int getVotesCount() {
    return votesCount;
  }

  public void setVotesCount(int votesCount) {
    this.votesCount = votesCount;
  }

  public void voteFor() {
    System.out.println("Someone voted for answer : " + this.getText());
    this.setVotesCount(this.getVotesCount() + 1);
    if (votesCount >= myQuestion.getVotesToBeChanged()) {
      swapAnswer();
      this.setVotesCount(0);
      reduceAllOtherVotesByHalf();
      myQuestion.setVotesToBeChanged(myQuestion.getVotesToBeChanged() * 2);

    }
  }

  private void swapAnswer() {
    String previousBestAnswer = myQuestion.getBestAnswer().getText();
    myQuestion.getBestAnswer().setText(this.getText());
    this.setText(previousBestAnswer);
  }

  private void reduceAllOtherVotesByHalf() {
    List<SuggestedAnswer> candidateAnswers = myQuestion.getCandidateAnswers();
    for (SuggestedAnswer answer : candidateAnswers) {
      int countBefore = answer.getVotesCount();
      answer.setVotesCount(countBefore / 2);
    }

  }

  public void voteAgainst() {
    System.out.println("Someone voted against answer : " + this.getText());
    this.setVotesCount(this.getVotesCount() - 1);
    if (this.getVotesCount() < -10) {
      deleteThisQuestion();
    }
  }

  private void deleteThisQuestion() {
    // TODO Auto-generated method stub
  }

}
