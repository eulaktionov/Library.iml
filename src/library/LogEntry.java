package library;

import org.joda.time.LocalDate;

public class LogEntry extends IdName {

    private Integer readerId;
    private Integer copyId;
    private LocalDate giveDate;
    private LocalDate getDate;

    public LogEntry(Integer readerId, Integer copyId) {
        this.readerId = readerId;
        this.copyId = copyId;
        this.giveDate = LocalDate.now();
        this.getDate = null;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getCopyId() {
        return copyId;
    }

    public void setCopyId(Integer bookId) {
        this.copyId = bookId;
    }

    public LocalDate getGiveDate() {
        return giveDate;
    }

    public void setGiveDate(LocalDate giveDate) {
        this.giveDate = giveDate;
    }

    public LocalDate getGetDate() {
        return getDate;
    }

    public void setGetDate(LocalDate getDate) {
        this.getDate = getDate;
    }
}

