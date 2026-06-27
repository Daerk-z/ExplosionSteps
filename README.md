# ExplosionSteps

![Version](https://img.shields.io/badge/Version-1.0.0-black)
![Spigot](https://img.shields.io/badge/Spigot-26.1.2-yellow)
![Java](https://img.shields.io/badge/Java-25-blue)

A Minecraft plugin that make you explode if you walk on a specific block.

## Features

- It makes the player explode upon touching a specific block.

## Requeriments

- Minecraft version: 26.1.2
- Required Java: 25
- Compatible API: Spigot

## Installation

- Go and download the latest release [here](https://github.com/Daerk-z/ExplosionSteps/releases/tag/1.0.0)
- Download the `.jar` file
- Put the `.jar` file in the plugin folder of your server
- Restart your server to enable the plugin

## Configuration

```yaml

#######################################################################
#  ████████▄     ▄████████    ▄████████    ▄████████    ▄█   ▄█▄      #
#  ███   ▀███   ███    ███   ███    ███   ███    ███   ███ ▄███▀      #
#  ███    ███   ███    ███   ███    █▀    ███    ███   ███▐██▀        #
#  ███    ███   ███    ███  ▄███▄▄▄      ▄███▄▄▄▄██▀  ▄█████▀         #
#  ███    ███ ▀███████████ ▀▀███▀▀▀       ███▀▀▀▀▀   ▀▀█████▄         #
#  ███    ███   ███    ███   ███    █▄   ▀██████████   ███▐██▄        #
#  ███   ▄███   ███    ███   ███    ███   ███    ███   ███ ▀███▄      #
#  ████████▀    ███    █▀    ██████████   ███    ███   ███   ▀█▀      #
#                                                                     #
#######################################################################

config:
## Here you can change the block that should be detected so that it explodes when a playes is on it.
## DEFAULT: GRASS_BLOCK
## Page containing information about blocks in Minecraft: https://minecraftitemids.com
  block_explode:
    block: GRASS_BLOCK
```
