package db_demo.db_demo.model;

import javax.persistence.*;

@Entity
@Table(name = "order_item_notes", schema = "sql_store")
public class OrderItemNotes {
    private int noteId;
    private String note;

    @Id
    @Column(name = "note_id")
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemNotes that = (OrderItemNotes) o;

        if (noteId != that.noteId) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteId;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
