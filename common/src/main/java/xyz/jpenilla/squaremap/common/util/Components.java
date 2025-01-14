package xyz.jpenilla.squaremap.common.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import xyz.jpenilla.squaremap.common.data.MapWorldInternal;

@DefaultQualifier(NonNull.class)
public final class Components {
    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    public static MiniMessage miniMessage() {
        return MINI_MESSAGE;
    }

    public static Component miniMessage(final String miniMessage) {
        return miniMessage().deserialize(miniMessage);
    }

    public static Component miniMessage(final String miniMessage, final TagResolver... templates) {
        return miniMessage().deserialize(miniMessage, templates);
    }

    public static TagResolver.Single placeholder(final String name, final ComponentLike value) {
        return Placeholder.component(name, value);
    }

    public static TagResolver.Single placeholder(final String name, final Object value) {
        return Placeholder.unparsed(name, value.toString());
    }

    public static TagResolver.Single worldPlaceholder(final MapWorldInternal mapWorld) {
        return placeholder("world", mapWorld.identifier().asString());
    }

    public static TagResolver.Single worldPlaceholder(final ServerLevel level) {
        return placeholder("world", level.dimension().location());
    }

    public static TagResolver.Single playerPlaceholder(final ServerPlayer player) {
        return placeholder("player", player.getGameProfile().getName());
    }
}
