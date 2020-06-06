package io.github.elementera.api.common.items;

import io.github.elementera.api.config.CenterConfig;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import static net.minecraft.item.ItemGroup.MISC;
import static net.minecraft.item.Items.BUCKET;
import static net.minecraft.util.registry.Registry.ITEM;
import static net.minecraft.util.registry.Registry.register;

public class RegisterItem {
    public static final Settings s0, s1,recipeBucket, bucket;
    public static final Item fresh_bucket, hydrogen;
    static {
        s0 = new Settings();s1 = DCount(s0);
        recipeBucket = new Settings().recipeRemainder(BUCKET).maxCount(1);
        bucket = recipeBucket.group(MISC);
        fresh_bucket = getBucket(bucket);hydrogen = get(s1);
    }
    public RegisterItem() {
        Reg("hydrogen", hydrogen);
        Reg("fresh_water_bucket", fresh_bucket);
    }
    public static Item getBucket(Settings settings) {
        return new BucketSetting(settings);
    }
    public static Item get(Settings settings) {
        return new GetSetting(settings);
    }
    public static void Reg(String s, Item item) {
        register(ITEM, new Identifier("elementera", s), item);
    }
    public static Settings DCount(Settings settings) {
        return settings.maxCount(getPint("dcount"));//default count
    }
    // get center config load
    public static double getPDouble(String s) { return Double.parseDouble(s); }
    public static short getPShort(String s) { return Short.parseShort(s); }
    public static long getPLong(String s) { return Long.parseLong(s); }
    public static boolean getPBoolean(String s) { return Boolean.parseBoolean(s); }
    public static String getPString(String s) { return CenterConfig.getConfig.getProperty(s); }
    public static int getPint(String s) { return Integer.parseInt(CenterConfig.getConfig.getProperty(s)); }
}
class GetSetting extends Item {
    public GetSetting(Settings settings) { super(settings); }
}
class BucketSetting extends Item {
    public BucketSetting(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (user instanceof PlayerEntity && !((PlayerEntity)user).abilities.creativeMode) {
            stack.decrement(1);
        }

        return stack.isEmpty() ? new ItemStack(BUCKET) : stack;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
