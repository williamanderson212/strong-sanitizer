package me.wando;

import me.wando.listener.WorkoutMessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.jetbrains.annotations.NotNull;

import static net.dv8tion.jda.api.requests.GatewayIntent.DIRECT_MESSAGES;
import static net.dv8tion.jda.api.requests.GatewayIntent.MESSAGE_CONTENT;

public class Main {

    public static void main(String @NotNull [] args) throws InterruptedException {
        JDA jda = JDABuilder.createDefault(args[0])
                .enableIntents(MESSAGE_CONTENT, DIRECT_MESSAGES)
                .addEventListeners(new WorkoutMessageListener())
                .build();

        jda.awaitReady();
    }
}
