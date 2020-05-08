package io.github.elementera.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.Calendar;
import java.util.List;

import static io.github.elementera.items.Public.NONMETALS;

class B6 extends Item {
    public B6() {
        super(new Settings().group(NONMETALS).maxCount(16));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(1, new TranslatableText(""));
        int i = 60 - Calendar.SECOND;
        tooltip.set(1, new TranslatableText(String.valueOf(i)));
    }

}class B7 extends Item {
    public B7() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B8 extends Item {
    public B8() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B9 extends Item {
    public B9() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B10 extends Item {
    public B10() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B11 extends Item {
    public B11() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B12 extends Item {
    public B12() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B13 extends Item {
    public B13() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B14 extends Item {
    public B14() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B15 extends Item {
    public B15() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B16 extends Item {
    public B16() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B17 extends Item {
    public B17() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B18 extends Item {
    public B18() { super(new Settings().group(NONMETALS).maxCount(16)); }
}class B19 extends Item {
    public B19() { super(new Settings().group(NONMETALS).maxCount(16)); }
}
