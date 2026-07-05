<#import "/layout/auth.ftl" as auth>

<@auth.main>
    <div class="login-container">
        <!-- Theme Toggle -->
        <div class="theme-toggle-wrapper">
            <button id="themeToggle" class="theme-toggle" aria-label="Toggle theme">
                <i class="bi bi-moon-stars-fill"></i>
            </button>
        </div>

        <!-- Logo Section -->
        <div class="login-logo-section">
            <div class="logo-wrapper">
                <img src="/images/logo.png" alt="OmniHub Logo" class="login-logo">
            </div>
            <h1 class="brand-title">OmniHub</h1>
            <p class="brand-subtitle">Secure Access Portal</p>
        </div>

        <!-- Login Form Section -->
        <div class="login-form-section">
            <div class="login-card">
                <div class="login-header">
                    <h2>Welcome Back</h2>
                    <p>Sign in to your account</p>
                </div>

                <#if page.data?? && page.data.errorMessage??>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <i class="bi bi-exclamation-circle-fill"></i>
                        ${page.data.errorMessage}
                        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    </div>
                </#if>

                <form method="post" action="/login" class="login-form">
                    <!-- Username Field -->
                    <div class="form-group">
                        <label for="username" class="form-label">
                            <i class="bi bi-person-fill"></i>
                            Username
                        </label>
                        <input 
                            type="text" 
                            id="username" 
                            name="username" 
                            class="form-control form-control-lg"
                            placeholder="Enter your username"
                            required
                            autofocus
                        />
                    </div>

                    <!-- Password Field -->
                    <div class="form-group">
                        <label for="password" class="form-label">
                            <i class="bi bi-lock-fill"></i>
                            Password
                        </label>
                        <input 
                            type="password" 
                            id="password" 
                            name="password" 
                            class="form-control form-control-lg"
                            placeholder="Enter your password"
                            required
                        />
                    </div>

                    <!-- Remember Me & Forgot Password -->
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="rememberMe">
                            <label class="form-check-label" for="rememberMe">
                                Remember me
                            </label>
                        </div>
                        <a href="#" class="forgot-password-link">Forgot password?</a>
                    </div>

                    <!-- Login Button -->
                    <button type="submit" class="btn btn-login btn-lg w-100">
                        <i class="bi bi-box-arrow-in-right"></i>
                        Sign In
                    </button>
                </form>

                <!-- Sign Up Link -->
                <div class="login-footer">
                    <p>Don't have an account? 
                        <a href="/signup" class="signup-link">Create one</a>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <script src="/js/theme-toggle.js"></script>
</@auth.main>