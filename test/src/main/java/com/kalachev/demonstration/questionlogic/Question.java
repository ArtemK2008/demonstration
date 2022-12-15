package com.kalachev.demonstration.questionlogic;

import java.util.List;

public class Question {
  static final int VOICES_REQUERED_AT_START = 5;

  private int votesToBeChanged = VOICES_REQUERED_AT_START;
  private final String questionText;
  private Answer bestAnswer;
  List<SuggestedAnswer> candidateAnswers;

  public Question(String questionText) {
    super();
    this.questionText = questionText;
  }

  public int getVotesToBeChanged() {
    return votesToBeChanged;
  }

  public String getQuestionText() {
    return questionText;
  }

  public Answer getBestAnswer() {
    return bestAnswer;
  }

  public List<SuggestedAnswer> getCandidateAnswers() {
    return candidateAnswers;
  }

  public void setVotesToBeChanged(int votesToBeChanged) {
    this.votesToBeChanged = votesToBeChanged;
  }

  public void setBestAnswer(Answer bestAnswer) {
    this.bestAnswer = bestAnswer;
  }

  public void setCandidateAnswers(List<SuggestedAnswer> candidateAnswer) {
    this.candidateAnswers = candidateAnswer;
  }

}
