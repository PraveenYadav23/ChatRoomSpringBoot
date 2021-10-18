package com.pavi.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Praveen Yadav
 * @since 18-Oct-2021, 9:22 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String name;
    private String content;
    private String time;

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
