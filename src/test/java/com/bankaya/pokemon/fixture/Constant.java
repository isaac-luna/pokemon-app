package com.bankaya.pokemon.fixture;

/**
 * The Class Constant.
 */
public class Constant {

    /**
     * The Enum HeldItemVersion.
     */
    public enum HeldItemVersion {
        
        /** The ruby. */
        RUBY("ruby", "https://pokeapi.co/api/v2/version/7/"),
        
        /** The sapphire. */
        SAPPHIRE("sapphire", "https://pokeapi.co/api/v2/version/8/"),
        
        /** The emerald. */
        EMERALD("emerald", "https://pokeapi.co/api/v2/version/9/"),
        
        /** The firered. */
        FIRERED("firered", "https://pokeapi.co/api/v2/version/10/"),
        
        /** The leafgreen. */
        LEAFGREEN("leafgreen", "https://pokeapi.co/api/v2/version/11/"),
        
        /** The diamond. */
        DIAMOND("diamond", "https://pokeapi.co/api/v2/version/12/"),
        
        /** The pearl. */
        PEARL("pearl", "https://pokeapi.co/api/v2/version/13/"),
        
        /** The platinum. */
        PLATINUM("platinum", "https://pokeapi.co/api/v2/version/14/"),
        
        /** The heartgold. */
        HEARTGOLD("heartgold", "https://pokeapi.co/api/v2/version/15/"),
        
        /** The soulsilver. */
        SOULSILVER("soulsilver", "https://pokeapi.co/api/v2/version/16/"),
        
        /** The black. */
        BLACK("black", "https://pokeapi.co/api/v2/version/17/"),
        
        /** The white. */
        WHITE("white", "https://pokeapi.co/api/v2/version/18/"),
        
        /** The black 2. */
        BLACK_2("black-2", "https://pokeapi.co/api/v2/version/21/"),
        
        /** The white 2. */
        WHITE_2("white-2", "https://pokeapi.co/api/v2/version/22/"),
        
        /** The x. */
        X("x", "https://pokeapi.co/api/v2/version/23/"),
        
        /** The y. */
        Y("y", "https://pokeapi.co/api/v2/version/24/"),
        
        /** The omega ruby. */
        OMEGA_RUBY("omega-ruby", "https://pokeapi.co/api/v2/version/25/"),
        
        /** The alpha sapphire. */
        ALPHA_SAPPHIRE("alpha-sapphire", "https://pokeapi.co/api/v2/version/26/"),
        
        /** The sun. */
        SUN("x", "https://pokeapi.co/api/v2/version/27/"),
        
        /** The moon. */
        MOON("y", "https://pokeapi.co/api/v2/version/28/"),
        
        /** The ultra sun. */
        ULTRA_SUN("omega-ruby", "https://pokeapi.co/api/v2/version/29/"),
        
        /** The ultra moon. */
        ULTRA_MOON("alpha-sapphire", "https://pokeapi.co/api/v2/version/30/");

        /** The name. */
        private final String name;
        
        /** The url. */
        private final String url;

        /**
         * Instantiates a new held item version.
         *
         * @param name the name
         * @param url the url
         */
        HeldItemVersion(String name, String url) {
            this.name = name;
            this.url = url;
        }

        /**
         * Gets the name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the url.
         *
         * @return the url
         */
        public String getUrl() {
            return url;
        }
    }
    
    
    /**
     * The Enum Ability.
     */
    public enum Ability {
        
        /** The natural cure. */
        NATURAL_CURE("natural-cure", "https://pokeapi.co/api/v2/ability/30/", false, 1),
        
        /** The serene grace. */
        SERENE_GRACE("serene-grace", "https://pokeapi.co/api/v2/ability/32/", false, 2),
        
        /** The healer. */
        HEALER("healer", "https://pokeapi.co/api/v2/ability/131/", true, 3);

        /** The name. */
        private final String name;
        
        /** The url. */
        private final String url;
        
        /** The hidden. */
        private final boolean hidden;
        
        /** The slot. */
        private final int slot;

        /**
         * Instantiates a new ability.
         *
         * @param name the name
         * @param url the url
         * @param hidden the hidden
         * @param slot the slot
         */
        Ability(String name, String url, boolean hidden, int slot) {
            this.name = name;
            this.url = url;
            this.hidden = hidden;
            this.slot = slot;
        }

        /**
         * Gets the name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the url.
         *
         * @return the url
         */
        public String getUrl() {
            return url;
        }
        
        /**
         * Checks if is hidden.
         *
         * @return true, if is hidden
         */
        public boolean isHidden() {
            return hidden;
        }
        
        /**
         * Gets the slot.
         *
         * @return the slot
         */
        public int getSlot() {
            return slot;
        }
    }
}
