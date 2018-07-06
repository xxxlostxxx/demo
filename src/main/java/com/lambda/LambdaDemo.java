package com.lambda;

import com.alibaba.fastjson.JSON;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LambdaDemo {


    public static void main(String[] args) {
        String s = "var\\s.*?((?==)|(?=;))";
        String demo = "(function(){if(!PluginDetect)var PluginDetect={getNum:function(b,c){if(!this.num(b))return null;var a;if(typeof c==\"undefined\")a=/[\\d][\\d\\.\\_,-]*/.exec(b);else a=(new RegExp(c)).exec(b);return a?a[0].replace(/[\\.\\_-]/g,\",\"):null},hasMimeType:function(c){if(PluginDetect.isIE)return null;var b,a,d,e=c.constructor==String?[c]:c;for(d=0;d<e.length;d++){b=navigator.mimeTypes[e[d]];if(b&&b.enabledPlugin){a=b.enabledPlugin;if(a.name||a.description)return b}}return null},findNavPlugin:function(g,d){var a=\n" +
                "g.constructor==String?g:g.join(\".*\"),e=d===false?\"\":\"\\\\d\",b,c=new RegExp(a+\".*\"+e+\"|\"+e+\".*\"+a,\"i\"),f=navigator.plugins;for(b=0;b<f.length;b++)if(c.test(f[b].description)||c.test(f[b].name))return f[b];return null},AXO:window.ActiveXObject,getAXO:function(b,a){var f=null,d,c=false;try{f=new this.AXO(b);c=true}catch(d){}if(typeof a!=\"undefined\"){delete f;return c}return f},num:function(a){return typeof a!=\"string\"?false:/\\d/.test(a)},compareNums:function(g,e){var d=this,c,b,a,f=window.parseInt;if(!d.num(g)||\n" +
                "!d.num(e))return 0;if(d.plugin&&d.plugin.compareNums)return d.plugin.compareNums(g,e);c=g.split(\",\");b=e.split(\",\");for(a=0;a<Math.min(c.length,b.length);a++){if(f(c[a],10)>f(b[a],10))return 1;if(f(c[a],10)<f(b[a],10))return-1}return 0},formatNum:function(b){if(!this.num(b))return null;var a,c=b.replace(/\\s/g,\"\").replace(/[\\.\\_]/g,\",\").split(\",\").concat([\"0\",\"0\",\"0\",\"0\"]);for(a=0;a<4;a++)if(/^(0+)(.+)$/.test(c[a]))c[a]=RegExp.$2;if(!/\\d/.test(c[0]))c[0]=\"0\";return c[0]+\",\"+c[1]+\",\"+c[2]+\",\"+c[3]},\n" +
                "initScript:function(){var $=this,userAgent=navigator.userAgent;$.isIE=true;$.IEver=$.isIE&&/MSIE\\s*(\\d\\.?\\d*)/i.exec(userAgent)?parseFloat(RegExp.$1,10):-1;$.ActiveXEnabled=false;if($.isIE){var x,progid=[\"Msxml2.XMLHTTP\",\"Msxml2.DOMDocument\",\"Microsoft.XMLDOM\",\"ShockwaveFlash.ShockwaveFlash\",\"TDCCtl.TDCCtl\",\"Shell.UIHelper\",\"Scripting.Dictionary\",\"wmplayer.ocx\"];for(x=0;x<progid.length;x++)if($.getAXO(progid[x],1)){$.ActiveXEnabled=true;break}$.head=typeof document.getElementsByTagName!=\"undefined\"?\n" +
                "document.getElementsByTagName(\"head\")[0]:null}$.isGecko=!$.isIE&&typeof navigator.product==\"string\"&&/Gecko/i.test(navigator.product)&&/Gecko\\s*\\/\\s*\\d/i.test(userAgent)?true:false;$.GeckoRV=$.isGecko?$.formatNum(/rv\\s*\\:\\s*([\\.\\,\\d]+)/i.test(userAgent)?RegExp.$1:\"0.9\"):null;$.isSafari=!$.isIE&&/Safari\\s*\\/\\s*\\d/i.test(userAgent)?true:false;$.isChrome=/Chrome\\s*\\/\\s*\\d/i.test(userAgent)?true:false;$.onWindowLoaded(0)},init:function(c,a){if(typeof c!=\"string\")return-3;c=c.toLowerCase().replace(/\\s/g,\n" +
                "\"\");var b=this,d;if(typeof b[c]==\"undefined\")return-3;d=b[c];b.plugin=d;if(typeof d.installed==\"undefined\"||a==true){d.installed=null;d.version=null;d.version0=null;d.getVersionDone=null;d.$=b}b.garbage=false;if(b.isIE&&!b.ActiveXEnabled)if(b.plugin!=b.java)return-2;return 1},isMinVersion:function(g,e,c,b){return-3},getVersion:function(e,b,a){var d=PluginDetect,c=d.init(e),f;if(c<0)return null;f=d.plugin;if(f.getVersionDone!=1){f.getVersion(b,a);if(f.getVersionDone===null)f.getVersionDone=1}d.cleanup();\n" +
                "return f.version||f.version0},getInfo:function(f,c,b){var a={};var e=PluginDetect,d=e.init(f),g;if(d<0)return a;g=e.plugin;if(typeof g.getInfo!=\"undefined\"){if(g.getVersionDone===null)e.getVersion(f,c,b);a=g.getInfo()}return a},cleanup:function(){var a=this;if(a.garbage&&typeof window.CollectGarbage!=\"undefined\")window.CollectGarbage()},isActiveXObject:function(b){var d=this,a,g,f=\"/\",c='<object width=\"1\" height=\"1\" style=\"display:none\" '+d.plugin.getCodeBaseVersion(b)+\">\"+d.plugin.HTML+\"<\"+f+\"object>\";\n" +
                "if(d.head.firstChild)d.head.insertBefore(document.createElement(\"object\"),d.head.firstChild);else d.head.appendChild(document.createElement(\"object\"));d.head.firstChild.outerHTML=c;try{d.head.firstChild.classid=d.plugin.classID}catch(g){}a=false;try{if(d.head.firstChild.object)a=true}catch(g){}try{if(a&&d.head.firstChild.readyState<4)d.garbage=true}catch(g){}d.head.removeChild(d.head.firstChild);return a},codebaseSearch:function(c){var e=this;if(!e.ActiveXEnabled)return null;if(typeof c!=\"undefined\")return e.isActiveXObject(c);\n" +
                "var j=[0,0,0,0],g,f,b=e.plugin.digits,i=function(k,m){var l=(k==0?m:j[0])+\",\"+(k==1?m:j[1])+\",\"+(k==2?m:j[2])+\",\"+(k==3?m:j[3]);return e.isActiveXObject(l)};var h,d,a=false;for(g=0;g<b.length;g++){h=b[g]*2;j[g]=0;for(f=0;f<20;f++){if(h==1&&g>0&&a)break;if(h-j[g]>1){d=Math.round((h+j[g])/2);if(i(g,d)){j[g]=d;a=true}else h=d}else if(h-j[g]==1){h--;if(!a&&i(g,h))a=true;break}else{if(!a&&i(g,h))a=true;break}}if(!a)return null}return j.join(\",\")},dummy1:0};PluginDetect.onDetectionDone=function(g,e,d,a){return-1};\n" +
                "PluginDetect.onWindowLoaded=function(c){var b=PluginDetect,a=window;if(b.EventWinLoad===true);else{b.winLoaded=false;b.EventWinLoad=true;if(typeof a.addEventListener!=\"undefined\")a.addEventListener(\"load\",b.runFuncs,false);else if(typeof a.attachEvent!=\"undefined\")a.attachEvent(\"onload\",b.runFuncs);else{if(typeof a.onload==\"function\")b.funcs[b.funcs.length]=a.onload;a.onload=b.runFuncs}}if(typeof c==\"function\")b.funcs[b.funcs.length]=c};PluginDetect.funcs=[0];PluginDetect.runFuncs=function(){var b=\n" +
                "PluginDetect,a;b.winLoaded=true;for(a=0;a<b.funcs.length;a++)if(typeof b.funcs[a]==\"function\"){b.funcs[a](b);b.funcs[a]=null}};PluginDetect.quicktime={mimeType:[\"video/quicktime\",\"application/x-quicktimeplayer\",\"image/x-macpaint\",\"image/x-quicktime\"],progID:\"QuickTimeCheckObject.QuickTimeCheck.1\",progID0:\"QuickTime.QuickTime\",classID:\"clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B\",minIEver:7,HTML:'<param name=\"src\" value=\"A14999.mov\" /><param name=\"controller\" value=\"false\" />',getCodeBaseVersion:function(a){return'codebase=\"#version='+\n" +
                "a+'\"'},digits:[8,64,16,0],clipTo3digits:function(f){if(f===null||typeof f==\"undefined\")return null;var e,d,h,g=this.$;e=f.split(\",\");if(g.compareNums(f,\"7,60,0,0\")<0&&g.compareNums(f,\"7,50,0,0\")>=0)d=e[0]+\",\"+e[1].charAt(0)+\",\"+e[1].charAt(1)+\",\"+e[2];else d=e[0]+\",\"+e[1]+\",\"+e[2]+\",\"+e[3];h=d.split(\",\");return h[0]+\",\"+h[1]+\",\"+h[2]+\",0\"},getVersion:function(){var a=null,d,b=this.$,e=true;if(!b.isIE){if(navigator.platform&&/linux/i.test(navigator.platform))e=false;if(e){d=b.findNavPlugin([\"QuickTime\",\n" +
                "\"(Plug-in|Plugin)\"]);if(d&&d.name&&b.hasMimeType(this.mimeType))a=b.getNum(d.name)}this.installed=a?1:-1}else{var c;if(b.IEver>=this.minIEver&&b.getAXO(this.progID0,1))a=b.codebaseSearch();else{c=b.getAXO(this.progID);if(c&&c.QuickTimeVersion){a=c.QuickTimeVersion.toString(16);a=a.charAt(0)+\".\"+a.charAt(1)+\".\"+a.charAt(2)}}this.installed=a?1:b.getAXO(this.progID0,1)?0:-1}this.version=this.clipTo3digits(b.formatNum(a))}};PluginDetect.devalvr={mimeType:\"application/x-devalvrx\",progID:\"DevalVRXCtrl.DevalVRXCtrl.1\",\n" +
                "classID:\"clsid:5D2CF9D0-113A-476B-986F-288B54571614\",getVersion:function(){var a=null,g,c=this.$,f;if(!c.isIE){g=c.findNavPlugin(\"DevalVR\");if(g&&g.name&&c.hasMimeType(this.mimeType))a=g.description.split(\" \")[3];this.installed=a?1:-1}else{var b,h,d;h=c.getAXO(this.progID,1);if(h){b=c.instantiate(\"object\",[\"classid\",this.classID],[\"src\",\"\"]);d=c.getObject(b);if(d)try{if(d.pluginversion){a=\"00000000\"+d.pluginversion.toString(16);a=a.substr(a.length-8,8);a=parseInt(a.substr(0,2),16)+\",\"+parseInt(a.substr(2,\n" +
                "2),16)+\",\"+parseInt(a.substr(4,2),16)+\",\"+parseInt(a.substr(6,2),16)}}catch(f){}c.uninstantiate(b)}this.installed=a?1:h?0:-1}this.version=c.formatNum(a)}};PluginDetect.flash={mimeType:[\"application/x-shockwave-flash\",\"application/futuresplash\"],progID:\"ShockwaveFlash.ShockwaveFlash\",classID:\"clsid:D27CDB6E-AE6D-11CF-96B8-444553540000\",getVersion:function(){var c=function(i){if(!i)return null;var e=/[\\d][\\d\\,\\.\\s]*[rRdD]{0,1}[\\d\\,]*/.exec(i);return e?e[0].replace(/[rRdD\\.]/g,\",\").replace(/\\s/g,\"\"):\n" +
                "null};var j,g=this.$,h,f,b=null,a=null,d=null;if(!g.isIE){j=g.findNavPlugin(\"Flash\");if(j&&j.description&&g.hasMimeType(this.mimeType))b=c(j.description)}else{for(f=15;f>2;f--){a=g.getAXO(this.progID+\".\"+f);if(a){d=f.toString();break}}if(d==\"6\")try{a.AllowScriptAccess=\"always\"}catch(h){return\"6,0,21,0\"}try{b=c(a.GetVariable(\"$version\"))}catch(h){}if(!b&&d)b=d}this.installed=b?1:-1;this.version=g.formatNum(b);return true}};PluginDetect.shockwave={mimeType:\"application/x-director\",progID:\"SWCtl.SWCtl\",\n" +
                "classID:\"clsid:166B1BCA-3F9C-11CF-8075-444553540000\",getVersion:function(){var a=null,b=null,f,d,c=this.$;if(!c.isIE){d=c.findNavPlugin(\"Shockwave for Director\");if(d&&d.description&&c.hasMimeType(this.mimeType))a=c.getNum(d.description)}else{try{b=c.getAXO(this.progID).ShockwaveVersion(\"\")}catch(f){}if(typeof b==\"string\"&&b.length>0)a=c.getNum(b);else if(c.getAXO(this.progID+\".8\",1))a=\"8\";else if(c.getAXO(this.progID+\".7\",1))a=\"7\";else if(c.getAXO(this.progID+\".1\",1))a=\"6\"}this.installed=a?1:-1;\n" +
                "this.version=c.formatNum(a)}};PluginDetect.div=null;PluginDetect.pluginSize=1;PluginDetect.DOMbody=null;PluginDetect.uninstantiate=function(a){var c,b=this;if(!a)return;try{if(a[0]&&a[0].firstChild)a[0].removeChild(a[0].firstChild);if(a[0]&&b.div)b.div.removeChild(a[0]);if(b.div&&b.div.childNodes.length==0){b.div.parentNode.removeChild(b.div);b.div=null;if(b.DOMbody&&b.DOMbody.parentNode)b.DOMbody.parentNode.removeChild(b.DOMbody);b.DOMbody=null}a[0]=null}catch(c){}};PluginDetect.getObject=function(b,\n" +
                "a){var f,c=this,d=null;try{if(b&&b[0]&&b[0].firstChild)d=b[0].firstChild}catch(f){}try{if(a&&d&&typeof d.focus!=\"undefined\"&&typeof document.hasFocus!=\"undefined\"&&!document.hasFocus())d.focus()}catch(f){}return d};PluginDetect.getContainer=function(a){var c,b=null;if(a&&a[0])b=a[0];return b};PluginDetect.hideObject=function(a){var b=this.getObject(a);if(b&&b.style)b.style.height=\"0\"};PluginDetect.instantiate=function(h,b,c,a){var j=function(d){var e=d.style;if(!e)return;e.border=\"0px\";e.padding=\n" +
                "\"0px\";e.margin=\"0px\";e.fontSize=g.pluginSize+3+\"px\";e.height=g.pluginSize+3+\"px\";e.visibility=\"visible\";if(d.tagName&&d.tagName.toLowerCase()==\"div\"){e.width=\"100%\";e.display=\"block\"}else if(d.tagName&&d.tagName.toLowerCase()==\"span\"){e.width=g.pluginSize+\"px\";e.display=\"inline\"}};var k,l=document,g=this,p,i=l.getElementsByTagName(\"body\")[0]||l.body,o=l.createElement(\"span\"),n,f,m=\"/\";if(typeof a==\"undefined\")a=\"\";p=\"<\"+h+' width=\"'+g.pluginSize+'\" height=\"'+g.pluginSize+'\" ';for(n=0;n<b.length;n=\n" +
                "n+2)p+=b[n]+'=\"'+b[n+1]+'\" '";
        Pattern p=Pattern.compile(s);
        Matcher matcher = p.matcher(demo);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }

    public static void demo1(){
        Runnable noArgument = () -> System.out.println("Heelo");
        ActionListener one = event -> System.out.println("button");
        Runnable multi = () -> {
            System.out.println("2212");
            System.out.println("2212");
        };
        BinaryOperator<Long> add = (x,y) -> x+y;
    }







}
