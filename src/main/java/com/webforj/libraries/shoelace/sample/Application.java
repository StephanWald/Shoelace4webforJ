package com.webforj.libraries.shoelace.sample;

import com.webforj.App;
import com.webforj.annotation.AppProfile;
import com.webforj.annotation.AppTheme;
import com.webforj.annotation.Routify;
import com.webforj.annotation.StyleSheet;

@Routify(packages = "com.webforj.libraries.shoelace.sample.views")
@StyleSheet("ws://app.css")
@AppTheme("system")
@AppProfile(name = "Shoelace Components in webforJ", shortName = "Shoelace webforJ")
public class Application extends App {
}
