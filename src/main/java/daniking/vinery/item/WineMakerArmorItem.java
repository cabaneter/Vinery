package daniking.vinery.item;

import daniking.vinery.client.ClientSetup;
import daniking.vinery.registry.ObjectRegistry;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public interface WineMakerArmorItem {

    default void tooltip(List<Text> tooltip){
        PlayerEntity player = ClientSetup.getClientPlayer();
        if (player == null) return;
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        tooltip.add(Text.of(""));
        tooltip.add(Text.of(Formatting.AQUA + I18n.translate("vinery.tooltip.winemaker_armor")));
        tooltip.add(Text.of((helmet != null && helmet.getItem() instanceof WineMakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.STRAW_HAT.getName().getString() + "]"));
        tooltip.add(Text.of((chestplate != null && chestplate.getItem() instanceof WineMakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.VINEMAKER_APRON.getName().getString() + "]"));
        tooltip.add(Text.of((leggings != null && leggings.getItem() instanceof WineMakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.VINEMAKER_LEGGINGS.getName().getString() + "]"));
        tooltip.add(Text.of((boots != null && boots.getItem() instanceof WineMakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.VINEMAKER_BOOTS.getName().getString() + "]"));
        tooltip.add(Text.of(""));
        tooltip.add(Text.of(Formatting.GRAY + I18n.translate("vinery.tooltip.winemaker_armor2")));
        tooltip.add(Text.of(((helmet != null && helmet.getItem() instanceof WineMakerArmorItem &&
                chestplate != null && chestplate.getItem() instanceof WineMakerArmorItem &&
                leggings != null && leggings.getItem() instanceof WineMakerArmorItem &&
                boots != null && boots.getItem() instanceof WineMakerArmorItem) ? Formatting.DARK_GREEN.toString() : Formatting.GRAY.toString()) + I18n.translate("vinery.tooltip.winemaker_armor3")));
    }

}