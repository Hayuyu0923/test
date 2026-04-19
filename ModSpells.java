package net.kaupenjoe.tutorialmod;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSpells {
    // 修正案: "discerning_the_eldritch" は自分の mod_id に書き換えてください
    public static final DeferredRegister<AbstractSpell> SPELLS =
            DeferredRegister.create(SpellRegistry.SPELLS_REGISTRY_KEY, "discerning_the_eldritch");

    // RhittaSpell::new でエラーが出る場合、RhittaSpell側のコンストラクタが原因です
    public static final DeferredHolder<AbstractSpell, RhittaSpell> RHITTA_SPELL =
            SPELLS.register("rhitta_spell", RhittaSpell::new);

    public static void register(IEventBus eventBus) {
        SPELLS.register(eventBus);
    }
}
