# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project overview

ExplosionSteps is a Spigot/Bukkit Minecraft plugin. It makes a player explode when they walk onto a configured block (default `GRASS_BLOCK`).

- Minecraft/Spigot API: 26.1.2 (`api-version: 1.21` in plugin.yml)
- Java: 25
- Build tool: Maven

## Commands

- Build the plugin jar: `mvn clean package` (output in `target/`)
- Compile only: `mvn compile`
- There are no automated tests in this repository (no test dependency/framework is configured).

## Architecture

Entry point is `ExplosionSteps` (`src/main/java/dev/daerk/explosionsteps/ExplosionSteps.java`), a `JavaPlugin`. On `onEnable()` it:
1. Constructs a `FileConfigManager`, which loads `config.yml` and stores it on the plugin instance (`getFileConfigManager()`).
2. Schedules `GrassExplosionTask` as a repeating `BukkitRunnable` via `runTaskTimer(this, 0, 1)` — it runs **every tick**, not on a block/move event.

`GrassExplosionTask` (`task/GrassExplosionTask.java`) is the core loop: each tick it iterates all online players and, for each one, checks (in this order, short-circuiting) permission `xs.explode.use` → block-below check → per-player cooldown → triggers the explosion. Tunable values (`explosionPower`, `breakBlocks`, `setFire`, cooldown ms) are currently hardcoded fields on this class, not read from config.

Config layer (`config/`):
- `CustomConfig` is a generic reusable wrapper around a Bukkit `YamlConfiguration` file (handles create/load/save/reload for any named file/folder).
- `FileConfigManager` is the plugin-specific layer on top of it: it owns the single `config.yml` `CustomConfig` instance and exposes typed accessors (currently just `getBlocks()`, read as a string list from `config.block_explode.blocks`). Add new config values here, not by reading `CustomConfig` directly elsewhere.
- `reloadConfig()` exists on `FileConfigManager`/`CustomConfig` but nothing currently invokes it (no reload command is registered).

Utils (`utils/`):
- `BlockCheckUtil.isConfiguredBlockBelow` — resolves each configured block name to a `Material` via `Material.matchMaterial` and returns true if the block beneath the player matches any of them.
- `CooldownUtil` — simple per-`UUID` millisecond cooldown backed by a `ConcurrentHashMap`; one instance per task with a fixed cooldown window.
- `ExplosionUtil.createExplosion` — thin wrapper over `World#createExplosion`.
- `MessageColors.coloredMessage` — translates `&`-based color codes for console/chat messages.

## Config file (`src/main/resources/config.yml`)

Key: `config.block_explode.blocks` (a YAML list, default `[GRASS_BLOCK]`), each entry matched against Bukkit `Material` names — a player exploding on any listed block. This is the file end users edit after installing the plugin; keep the shipped default in sync with `FileConfigManager`'s expectations.

## Permissions (`plugin.yml`)

`xs.explode.use` (default: `true`) gates whether a player triggers the explosion effect.
