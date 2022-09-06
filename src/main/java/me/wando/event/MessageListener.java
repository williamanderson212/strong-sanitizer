package me.wando.event;

import me.wando.sanitizer.InputProcessor;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    private final InputProcessor inputProcessor = new InputProcessor();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        User user = event.getAuthor();

        Message message = event.getMessage();
        String content = message.getContentRaw();

        if (channel.getName().equals("sanitizer-test") && content.contains("https://strong.app.link/")) {
            String builder = user.getName() + ":\n" +
                    inputProcessor.createWorkout(content);

            System.out.println(user.getId());

            channel.deleteMessageById(message.getId()).queue();
            channel.sendMessage(builder).queue();
        }
    }
}
