package com.example.trainingcentermanagement.Model;

public class Session {

    private int session_id;
    private int course_id;
    private String title;
    private String content;

    //----------------------------------------------------

    public Session() {
    }

    public Session(int session_id, int course_id, String title, String content) {
        this.session_id = session_id;
        this.course_id = course_id;
        this.title = title;
        this.content = content;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Session{" +
                "session_id=" + session_id +
                ", course_id=" + course_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
