package chemicraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import chemicraft.lib.RawMaterials;
import chemicraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemIngotMetal extends CCMetaItem {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubItems(Item item, CreativeTabs tabs, List par3List) {
		for(int i = 0; i < RawMaterials.addedMetals.length; i++) {
			par3List.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		icons = new IIcon[RawMaterials.addedMetals.length];
		for (int i = 0; i < RawMaterials.addedMetals.length; ++i) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":ingot" + RawMaterials.addedMetals[i]);
        }
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {

        int i = MathHelper.clamp_int(meta, 0, RawMaterials.addedMetals.length - 1);
        return icons[i];
    }
	
	@Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, RawMaterials.addedMetals.length - 1);
        return "item.CCIngot" + RawMaterials.addedMetals[meta];
    }
	
	
}
