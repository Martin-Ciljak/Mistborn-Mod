package net.chilly.mistbornmod.event;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.effect.ModEffects;
import net.chilly.mistbornmod.item.ModItems;
import net.chilly.mistbornmod.item.custom.TutorialHammerItem;
import net.chilly.mistbornmod.potion.ModPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = MistbornMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof TutorialHammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : TutorialHammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if(event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
          if(player.getMainHandItem().getItem() == Items.END_ROD) {
              player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a sheep with an endrod"));
              sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 2));
              sheep.hurt(sheep.damageSources().playerAttack(player), 1000f);
              if (!player.hasInfiniteMaterials()) {
                  player.getMainHandItem().shrink(1);
              }

          }
        }
    }

    @SubscribeEvent
    public static void onPlayerClickItem(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
        if(!player.level().isClientSide) {
            BlockHitResult target = findMetalTarget(player, player.level(), 32);
            if(target != null) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just STEEL PUSHED"));
                MistbornMod.LOGGER.debug("------------STEEL PUSH ITEM-----------------------------");
            } else {
                MistbornMod.LOGGER.debug("------------Debug ITEM---------");
            }
        }
    }

//    @SubscribeEvent
//    public static void OnPlayerClickEmpty(PlayerInteractEvent.RightClickEmpty event){
//        Player player = event.getEntity();
//        if(player.level().isClientSide) {
//            BlockHitResult target = findMetalTarget(player, player.level(), 32);
//            if(target != null) {
//                MistbornMod.LOGGER.debug("------------STEEL PUSH EMPTY----------------------------");
//            } else {
//                MistbornMod.LOGGER.debug("------------Debug-EMPTY-------");
//            }
//        }
//    }

    @SubscribeEvent
    public static void OnPlayerClickBlock(PlayerInteractEvent.RightClickBlock event){
        Player player = event.getEntity();
        if(!player.level().isClientSide) {
            BlockHitResult target = findMetalTarget(player, player.level(), 32);
            if(target != null) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just STEEL PUSHED"));
                MistbornMod.LOGGER.debug("------------STEEL PUSH BLOCK----------------------------");
            } else {
                MistbornMod.LOGGER.debug("------------Debug- BLOCK-------");
            }
        }
    }

    @SubscribeEvent
    public static void OnPlayerClickEntity(PlayerInteractEvent.EntityInteract event){
        Player player = event.getEntity();
        if(!player.level().isClientSide) {
            BlockHitResult target = findMetalTarget(player, player.level(), 32);
            if(target != null) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just STEEL PUSHED"));
                MistbornMod.LOGGER.debug("------------STEEL PUSH ENTITY----------------------------");
            } else {
                MistbornMod.LOGGER.debug("------------Debug- ENTITY-------");
            }
        }
    }

    public static void Hi(InputEvent.InteractionKeyMappingTriggered event) {

    }
//    @SubscribeEvent
//    public static void OnPlayerClickEntitySpecific(PlayerInteractEvent.EntityInteractSpecific event){
//        Player player = event.getEntity();
//        if(!player.level().isClientSide) {
//            BlockHitResult target = findMetalTarget(player, player.level(), 32);
//            if(target != null) {
//                MistbornMod.LOGGER.debug("------------STEEL PUSH ENTITY S----------------------------");
//            } else {
//                MistbornMod.LOGGER.debug("------------Debug- ENTITY S-------");
//            }
//        }
//    }

//        Player player = event.getEntity();
//        event.getHand()
//        if (!player.level().isClientSide) {
//            BlockHitResult target = findMetalTarget(player, player.level(), 32);
//            if (target != null) {
//                steelPush(player, target.getBlockPos());
//            }
//        }


    public static BlockHitResult findMetalTarget(Player player, Level level, double maxDistance) {
        Vec3 eyePos = player.getEyePosition(1.0F);
        Vec3 lookVec = player.getLookAngle();
        Vec3 endVec = eyePos.add(lookVec.scale(maxDistance));

        // Perform a block raytrace but don't stop at the first hit
        BlockPos targetPos = null;
        for (int i = 0; i <= maxDistance; i++) {
            Vec3 checkPos = eyePos.add(lookVec.scale(i));
            BlockPos blockPos = BlockPos.containing(checkPos);
            BlockState state = level.getBlockState(blockPos);

            if (isMetalBlock(state)) {
                targetPos = blockPos;
                break; // Take the first metal block
            }
        }

        return targetPos != null ? new BlockHitResult(Vec3.atCenterOf(targetPos), Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), targetPos, false) : null;
    }
    @SubscribeEvent
    public static void onLivingHurt(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity.hasEffect(ModEffects.PEWTER_EFFECT)) {
            int amplifier = entity.getEffect(ModEffects.PEWTER_EFFECT).getAmplifier();
            float reductionFactor = 1.0F - (0.2F * (amplifier + 1)); // 20% per level
            reductionFactor = Math.max(reductionFactor, 0.4F); // Cap at 60% reduction
            event.setAmount(event.getOriginalAmount() * reductionFactor);
        }
    }

//    @SubscribeEvent
//    public static void onRenderLevel(RenderLevelStageEvent event) {
//        Minecraft mc = Minecraft.getInstance();
//        LocalPlayer player = mc.player;
//
//        if (player != null && player.hasEffect(ModEffects.PEWTER_EFFECT)) {
//            mc.options.gamma().set(1.8); // Max brightness
//        } else {
//            mc.options.gamma().set(1.0); // Reset to default
//        }
//    }



    private static boolean isMetalBlock(BlockState state) {
        return state.is(Blocks.IRON_BLOCK);
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.COMMAND_BLOCK, ModPotions.ADMIN_POTION);
        builder.addMix(ModPotions.ADMIN_POTION, ModItems.PEWTER_INGOT.get(), ModPotions.PEWTER_POTION);
    }
}