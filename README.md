# ExplosionSteps

![Version](https://img.shields.io/badge/Version-1.0.0-black)
![Spigot](https://img.shields.io/badge/Spigot-26.1.2-yellow)
![Java](https://img.shields.io/badge/Java-25-blue)

A Minecraft plugin that make you explode if you walk on a specific block.

## Features

- Makes a player explode when they step on any block from a configurable list (default: `GRASS_BLOCK`).
- Per-player cooldown so it doesn't re-trigger every tick.

## Requirements

- JDK: **25**
- Build tool: **Maven** 3.6+
- Runtime: Spigot/Paper server, API version 1.21 (Spigot **26.1.2**)

## Building from source

Clone the repo and build the jar with Maven:

```bash
git clone git@github.com:Daerk-z/ExplosionSteps.git
cd ExplosionSteps
mvn clean package
```

The compiled plugin jar is written to `target/ExplosionSteps-<version>.jar`.

Other useful commands:

```bash
mvn compile        # compile only, skip packaging
mvn clean          # remove target/
```

> There is no test suite configured for this project (no test dependency/framework is set up in `pom.xml`).

### Local testing

To try a build on a real server, copy the jar from `target/` into that server's `plugins/` folder and (re)start the server:

```bash
cp target/ExplosionSteps-*.jar /path/to/server/plugins/
```

## Installation (pre-built release)

- Go and download the latest release [here](https://github.com/Daerk-z/ExplosionSteps/releases/tag/1.0.0)
- Download the `.jar` file
- Put the `.jar` file in the plugin folder of your server
- Restart your server to enable the plugin

## Configuration

`config.yml` is generated on first run inside the plugin's data folder. It lists the blocks that trigger an explosion when a player stands on them:

```yaml
config:
## Here you can list the blocks that should be detected so that a player explodes when standing on one of them.
## DEFAULT: [GRASS_BLOCK]
## Add more entries to trigger on additional blocks, e.g. DIRT.
## Page containing information about blocks in Minecraft: https://minecraftitemids.com
  block_explode:
    blocks:
      - GRASS_BLOCK
```

Add more `Material` names under `blocks` to trigger on additional block types.

## Permissions

| Permission | Default | Description |
|---|---|---|
| `xs.explode.use` | `true` | Allows a player to trigger the explosion effect. |
