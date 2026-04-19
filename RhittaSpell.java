
 package net.kaupenjoe.tutorialmod;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class RhittaSpell extends AbstractSpell {
    // 1.21.1 用の ResourceLocation 生成方法
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("discerning_the_eldritch", "rhitta_spell");

    // DefaultConfig のセットアップ
    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(20)
            .setManaCostPerLevel(50); // 最新版ではここに含まれる場合があります

    public RhittaSpell() {
        // 重要: 親クラス AbstractSpell は 1.21.1 ではコンストラクタに引数を取らない場合が多いですが、
        // もしエラーが出る場合は super(null); などを試す必要があります。基本は super(); でOK。
        super();
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.SELF_CAST_ANIMATION;
    }

    // 必須メソッド: これがないとコンパイルエラーになります
    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData magicData) {
        // ここにエスカノールの魔法効果（爆発や攻撃）を記述します
        // 例: entity の前方に爆発を起こすなど
        super.onCast(level, spellLevel, entity, castSource, magicData);
    }
}