package me.wando.discord;

import me.wando.model.Workout;
import me.wando.sanitizer.mapper.WorkoutMapper;
import me.wando.sanitizer.printer.PrinterMarkers;
import me.wando.sanitizer.printer.WorkoutPrinter;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;

import static me.wando.sanitizer.mapper.WorkoutMapper.*;
import static me.wando.sanitizer.printer.PrinterMarkers.COLON_;
import static me.wando.sanitizer.printer.WorkoutPrinter.*;
import static me.wando.sanitizer.processor.ProcessorMarkers._APP_LINK;

public class DiscordUtils {

    private static final String GYM_CHANNEL = "\uD83E\uDD8D-apes-together-strong";
    private static final String CODE_BLOCK = "\n```";

    public static void handleWorkout(MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();
        User user = event.getAuthor();
        Message message = event.getMessage();

        if (isWorkout(channel, message)) {
            sendWorkout(channel, message, user);
        }
    }

    private static void sendWorkout(MessageChannel channel, Message message, User user) {

        String userName = user.getName();
        String messageContent = message.getContentRaw();
        String messageId = message.getId();
        Workout workout = mapWorkout(messageContent);

        String newMessageContent = userName + COLON_ + printWorkout(workout);

        channel.deleteMessageById(messageId).queue();
        channel.sendMessage(CODE_BLOCK + newMessageContent + CODE_BLOCK).queue();
        sendWorkoutAsJson(user, workout);
    }

    private static void sendWorkoutAsJson(User user, Workout workout) {

        String json = new JSONObject(workout).toString();

        user.openPrivateChannel().flatMap(channel -> channel.sendMessage(json)).queue();
    }

    public static boolean isWorkout(MessageChannel channel, Message message) {

        String channelName = channel.getName();
        String messageContent = message.getContentRaw();

        return channelName.equals(GYM_CHANNEL) && messageContent.contains(_APP_LINK);
    }
}
