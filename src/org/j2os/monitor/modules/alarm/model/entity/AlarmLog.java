package org.j2os.monitor.modules.alarm.model.entity;

import org.j2os.monitor.modules.admin.model.entity.Admin;

import javax.persistence.*;

@Entity
@Table
public class AlarmLog {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="alarmlog_seq")
    @SequenceGenerator(name="alarmlog_seq", sequenceName="alarmlog_seq", allocationSize=1)
    private long id;

    @ManyToOne
    @JoinColumn(name = "alarm_note_id")
    private AlarmNote alarm_note_id;
    @Column(columnDefinition = "varchar2(200)")
    private String message;

    @ManyToOne
    private Admin admin;

    public AlarmLog() {
    }

    public AlarmLog(AlarmNote alarm_note_id, String message, Admin admin) {
        this.alarm_note_id = alarm_note_id;
        this.message = message;
        this.admin = admin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AlarmNote getAlarm_note_id() {
        return alarm_note_id;
    }

    public void setAlarm_note_id(AlarmNote alarm_note_id) {
        this.alarm_note_id = alarm_note_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
