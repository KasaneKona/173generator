# This code is horribly unstable! Do not use it in its current state! Issues will be resolved shortly.

## Updated for 1.14!
As the original author (Barteks2x) is no longer maintaining this plugin, I've updated it to Spigot 1.14.4. In addition, I have brought Maven tests into a working state. The test code is far from clean, but everything works. Unfortunately I skipped 1.13, so the plugin is unavailable for that version unless I decide to backport it.

## Beta 1.7.3 world generator
This plugin generates beta 1.7.3 terrain.

[Bukkit dev page](https://dev.bukkit.org/projects/b173gen/) (outdated)

### Usage

Use it like any other generator To use it without a multi-world plugin, append this to your bukkit.yml:
```yaml
worlds:
     world_name:
          generator: 173generator
```
To use it with a multi-world plugin such as Multiverse, follow the instructions for that plugin.
