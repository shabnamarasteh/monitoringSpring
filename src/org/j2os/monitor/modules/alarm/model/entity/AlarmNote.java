package org.j2os.monitor.modules.alarm.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class AlarmNote {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="alarmnote_seq")
    @SequenceGenerator(name="alarmnote_seq", sequenceName="alarmnote_seq", allocationSize=1)
    private long id;

    private long device_property_id;
    private String name;
    private String message;

    @OneToMany(mappedBy = "alarm_note_id")
    private List<AlarmLog> alarmLogList;

    public AlarmNote() {
    }

    public AlarmNote(long device_property_id, String name, String message, List<AlarmLog> alarmLogList) {
        this.device_property_id = device_property_id;
        this.name = name;
        this.message = message;
        this.alarmLogList = alarmLogList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDevice_property_id() {
        return device_property_id;
    }

    public void setDevice_property_id(long device_property_id) {
        this.device_property_id = device_property_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AlarmLog> getAlarmLogList() {
        return alarmLogList;
    }

    public void setAlarmLogList(List<AlarmLog> alarmLogList) {
        this.alarmLogList = alarmLogList;
    }
}
