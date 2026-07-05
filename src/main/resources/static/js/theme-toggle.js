// Theme Toggle Functionality
(function() {
    'use strict';

    const THEME_KEY = 'omnihub-theme';
    const LIGHT_THEME = 'light';
    const DARK_THEME = 'dark';

    // Initialize theme on page load
    function initializeTheme() {
        const savedTheme = localStorage.getItem(THEME_KEY);
        const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
        
        // Use saved theme or system preference
        const theme = savedTheme || (prefersDark ? DARK_THEME : LIGHT_THEME);
        applyTheme(theme);
    }

    // Apply theme to document
    function applyTheme(theme) {
        const html = document.documentElement;
        
        if (theme === DARK_THEME) {
            html.setAttribute('data-theme', DARK_THEME);
            localStorage.setItem(THEME_KEY, DARK_THEME);
            updateToggleButton(true);
        } else {
            html.removeAttribute('data-theme');
            localStorage.setItem(THEME_KEY, LIGHT_THEME);
            updateToggleButton(false);
        }
    }

    // Update toggle button icon
    function updateToggleButton(isDark) {
        const toggle = document.getElementById('themeToggle');
        if (toggle) {
            const icon = toggle.querySelector('i');
            if (isDark) {
                icon.classList.remove('bi-moon-stars-fill');
                icon.classList.add('bi-sun-fill');
            } else {
                icon.classList.remove('bi-sun-fill');
                icon.classList.add('bi-moon-stars-fill');
            }
        }
    }

    // Get current theme
    function getCurrentTheme() {
        return document.documentElement.getAttribute('data-theme') === DARK_THEME ? DARK_THEME : LIGHT_THEME;
    }

    // Toggle theme
    function toggleTheme() {
        const currentTheme = getCurrentTheme();
        const newTheme = currentTheme === LIGHT_THEME ? DARK_THEME : LIGHT_THEME;
        applyTheme(newTheme);
    }

    // Setup event listeners
    function setupEventListeners() {
        const toggle = document.getElementById('themeToggle');
        if (toggle) {
            toggle.addEventListener('click', toggleTheme);
        }

        // Listen for system theme changes
        window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', (e) => {
            const theme = e.matches ? DARK_THEME : LIGHT_THEME;
            applyTheme(theme);
        });
    }

    // Initialize when DOM is ready
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', function() {
            initializeTheme();
            setupEventListeners();
        });
    } else {
        initializeTheme();
        setupEventListeners();
    }
})();
