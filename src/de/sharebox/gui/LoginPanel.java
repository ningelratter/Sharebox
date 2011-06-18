
    

  

<!DOCTYPE html>
<html>
  <head>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <script type="text/javascript">var NREUMQ=[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
        <title>src/de/sharebox/gui/LoginPanel.java at master from ningelratter/Sharebox - GitHub</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />

    <link href="https://a248.e.akamai.net/assets.github.com/0906e92d585b0180aae00108a58dc63ee67817bb/stylesheets/bundle_github.css" media="screen" rel="stylesheet" type="text/css" />
    

    <script type="text/javascript">
      if (typeof console == "undefined" || typeof console.log == "undefined")
        console = { log: function() {} }
    </script>
    <script type="text/javascript" charset="utf-8">
      var GitHub = {
        assetHost: 'https://a248.e.akamai.net/assets.github.com'
      }
      var github_user = null
      
    </script>
    <script src="https://a248.e.akamai.net/assets.github.com/javascripts/jquery/jquery-1.6.1.min.js" type="text/javascript"></script>
    <script src="https://a248.e.akamai.net/assets.github.com/df956834986045362077968f64fceb78826da356/javascripts/bundle_github.js" type="text/javascript"></script>


    
    <script type="text/javascript" charset="utf-8">
      GitHub.spy({
        repo: "ningelratter/Sharebox"
      })
    </script>

    
  <link rel='canonical' href='/ningelratter/Sharebox/blob/30ffb9f4b528feed2b03a8327190b2d4e31092fe/src/de/sharebox/gui/LoginPanel.java'>

  <link href="https://github.com/ningelratter/Sharebox/commits/master.atom" rel="alternate" title="Recent Commits to Sharebox:master" type="application/atom+xml" />

        <meta name="description" content="Sharebox - a small student project" />
    <script type="text/javascript">
      GitHub.nameWithOwner = GitHub.nameWithOwner || "ningelratter/Sharebox";
      GitHub.currentRef = 'master';
      GitHub.commitSHA = "30ffb9f4b528feed2b03a8327190b2d4e31092fe";
      GitHub.currentPath = 'src/de/sharebox/gui/LoginPanel.java';
      GitHub.masterBranch = "master";

      
    </script>
  

        <script type="text/javascript">
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-3769691-2']);
      _gaq.push(['_setDomainName', 'none']);
      _gaq.push(['_trackPageview']);
      _gaq.push(['_trackPageLoadTime']);
      (function() {
        var ga = document.createElement('script');
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        ga.setAttribute('async', 'true');
        document.documentElement.firstChild.appendChild(ga);
      })();
    </script>

    
  </head>

  

  <body class="logged_out page-blob  windows env-production">
    

    

    

    <div class="subnavd" id="main">
      <div id="header" class="true">
        
          <a class="logo boring" href="https://github.com">
            
            <img alt="github" class="default" height="45" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov5.png" />
            <!--[if (gt IE 8)|!(IE)]><!-->
            <img alt="github" class="hover" height="45" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov5-hover.png" />
            <!--<![endif]-->
          </a>
        
        
        <div class="topsearch">
  
    <ul class="nav logged_out">
      
      <li class="pricing"><a href="/plans">Pricing and Signup</a></li>
      
      <li class="explore"><a href="/explore">Explore GitHub</a></li>
      <li class="features"><a href="/features">Features</a></li>
      
      <li class="blog"><a href="/blog">Blog</a></li>
      
      <li class="login"><a href="/login?return_to=%2Fningelratter%2FSharebox%2Fblob%2Fmaster%2Fsrc%2Fde%2Fsharebox%2Fgui%2FLoginPanel.java">Login</a></li>
    </ul>
  
</div>

      </div>

      
      
        
    <div class="site">
      <div class="pagehead repohead vis-public    instapaper_ignore readability-menu">

      

      <div class="title-actions-bar">
        <h1>
          <a href="/ningelratter">ningelratter</a> / <strong><a href="/ningelratter/Sharebox">Sharebox</a></strong>
          
          
        </h1>

        
    <ul class="actions">
      

      
        <li class="for-owner" style="display:none"><a href="/ningelratter/Sharebox/admin" class="minibutton btn-admin "><span><span class="icon"></span>Admin</span></a></li>
        <li>
          <a href="/ningelratter/Sharebox/toggle_watch" class="minibutton btn-watch " id="watch_button" onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '0c2a6eb493e2d0d76ee89cc644828ed78d4cc15b'); f.appendChild(s);f.submit();return false;" style="display:none"><span><span class="icon"></span>Watch</span></a>
          <a href="/ningelratter/Sharebox/toggle_watch" class="minibutton btn-watch " id="unwatch_button" onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '0c2a6eb493e2d0d76ee89cc644828ed78d4cc15b'); f.appendChild(s);f.submit();return false;" style="display:none"><span><span class="icon"></span>Unwatch</span></a>
        </li>
        
          
            <li class="for-notforked" style="display:none"><a href="/ningelratter/Sharebox/fork" class="minibutton btn-fork " id="fork_button" onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '0c2a6eb493e2d0d76ee89cc644828ed78d4cc15b'); f.appendChild(s);f.submit();return false;"><span><span class="icon"></span>Fork</span></a></li>
            <li class="for-hasfork" style="display:none"><a href="#" class="minibutton btn-fork " id="your_fork_button"><span><span class="icon"></span>Your Fork</span></a></li>
          

          
        
      
      
      <li class="repostats">
        <ul class="repo-stats">
          <li class="watchers"><a href="/ningelratter/Sharebox/watchers" title="Watchers" class="tooltipped downwards">1</a></li>
          <li class="forks"><a href="/ningelratter/Sharebox/network" title="Forks" class="tooltipped downwards">1</a></li>
        </ul>
      </li>
    </ul>

      </div>

        
  <ul class="tabs">
    <li><a href="/ningelratter/Sharebox" class="selected" highlight="repo_source">Source</a></li>
    <li><a href="/ningelratter/Sharebox/commits/master" highlight="repo_commits">Commits</a></li>
    <li><a href="/ningelratter/Sharebox/network" highlight="repo_network">Network</a></li>
    <li><a href="/ningelratter/Sharebox/pulls" highlight="repo_pulls">Pull Requests (0)</a></li>

    

    
      
      <li><a href="/ningelratter/Sharebox/issues" highlight="issues">Issues (0)</a></li>
    

                <li><a href="/ningelratter/Sharebox/wiki" highlight="repo_wiki">Wiki (5)</a></li>
        
    <li><a href="/ningelratter/Sharebox/graphs" highlight="repo_graphs">Graphs</a></li>

    <li class="contextswitch nochoices">
      <span class="toggle leftwards" >
        <em>Branch:</em>
        <code>master</code>
      </span>
    </li>
  </ul>

  <div style="display:none" id="pl-description"><p><em class="placeholder">click here to add a description</em></p></div>
  <div style="display:none" id="pl-homepage"><p><em class="placeholder">click here to add a homepage</em></p></div>

  <div class="subnav-bar">
  
  <ul>
    <li>
      <a href="/ningelratter/Sharebox/branches" class="dropdown">Switch Branches (1)</a>
      <ul>
        
          
            <li><strong>master &#x2713;</strong></li>
            
      </ul>
    </li>
    <li>
      <a href="#" class="dropdown defunct">Switch Tags (0)</a>
      
    </li>
    <li>
    
    <a href="/ningelratter/Sharebox/branches" class="manage">Branch List</a>
    
    </li>
  </ul>
</div>

  
  
  
  
  
  



        
    <div id="repo_details" class="metabox clearfix">
      <div id="repo_details_loader" class="metabox-loader" style="display:none">Sending Request&hellip;</div>

        <a href="/ningelratter/Sharebox/downloads" class="download-source" id="download_button" title="Download source, tagged packages and binaries."><span class="icon"></span>Downloads</a>

      <div id="repository_desc_wrapper">
      <div id="repository_description" rel="repository_description_edit">
        
          <p>a small student project
            <span id="read_more" style="display:none">&mdash; <a href="#readme">Read more</a></span>
          </p>
        
      </div>

      <div id="repository_description_edit" style="display:none;" class="inline-edit">
        <form action="/ningelratter/Sharebox/admin/update" method="post"><div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="0c2a6eb493e2d0d76ee89cc644828ed78d4cc15b" /></div>
          <input type="hidden" name="field" value="repository_description">
          <input type="text" class="textfield" name="value" value="a small student project">
          <div class="form-actions">
            <button class="minibutton"><span>Save</span></button> &nbsp; <a href="#" class="cancel">Cancel</a>
          </div>
        </form>
      </div>

      
      <div class="repository-homepage" id="repository_homepage" rel="repository_homepage_edit">
        <p><a href="http://" rel="nofollow"></a></p>
      </div>

      <div id="repository_homepage_edit" style="display:none;" class="inline-edit">
        <form action="/ningelratter/Sharebox/admin/update" method="post"><div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="0c2a6eb493e2d0d76ee89cc644828ed78d4cc15b" /></div>
          <input type="hidden" name="field" value="repository_homepage">
          <input type="text" class="textfield" name="value" value="">
          <div class="form-actions">
            <button class="minibutton"><span>Save</span></button> &nbsp; <a href="#" class="cancel">Cancel</a>
          </div>
        </form>
      </div>
      </div>
      <div class="rule "></div>
      <div id="url_box" class="url-box">
  

  <ul class="clone-urls">
    
      
      <li id="http_clone_url"><a href="https://github.com/ningelratter/Sharebox.git" data-permissions="Read-Only">HTTP</a></li>
      <li id="public_clone_url"><a href="git://github.com/ningelratter/Sharebox.git" data-permissions="Read-Only">Git Read-Only</a></li>
    
    
  </ul>
  <input type="text" spellcheck="false" id="url_field" class="url-field" />
        <span style="display:none" id="url_box_clippy"></span>
      <span id="clippy_tooltip_url_box_clippy" class="clippy-tooltip tooltipped" title="copy to clipboard">
      <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
              width="14"
              height="14"
              class="clippy"
              id="clippy" >
      <param name="movie" value="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"/>
      <param name="allowScriptAccess" value="always" />
      <param name="quality" value="high" />
      <param name="scale" value="noscale" />
      <param NAME="FlashVars" value="id=url_box_clippy&amp;copied=&amp;copyto=">
      <param name="bgcolor" value="#FFFFFF">
      <param name="wmode" value="opaque">
      <embed src="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"
             width="14"
             height="14"
             name="clippy"
             quality="high"
             allowScriptAccess="always"
             type="application/x-shockwave-flash"
             pluginspage="http://www.macromedia.com/go/getflashplayer"
             FlashVars="id=url_box_clippy&amp;copied=&amp;copyto="
             bgcolor="#FFFFFF"
             wmode="opaque"
      />
      </object>
      </span>

  <p id="url_description"><strong>Read+Write</strong> access</p>
</div>

    </div>

    <div class="frame frame-center tree-finder" style="display:none">
      <div class="breadcrumb">
        <b><a href="/ningelratter/Sharebox">Sharebox</a></b> /
        <input class="tree-finder-input" type="text" name="query" autocomplete="off" spellcheck="false">
      </div>

      
        <div class="octotip">
          <p>
            <a href="/ningelratter/Sharebox/dismiss-tree-finder-help" class="dismiss js-dismiss-tree-list-help" title="Hide this notice forever">Dismiss</a>
            <strong>Octotip:</strong> You've activated the <em>file finder</em> by pressing <span class="kbd">t</span>
            Start typing to filter the file list. Use <span class="kbd badmono">↑</span> and <span class="kbd badmono">↓</span> to navigate,
            <span class="kbd">enter</span> to view files.
          </p>
        </div>
      

      <table class="tree-browser" cellpadding="0" cellspacing="0">
        <tr class="js-header"><th>&nbsp;</th><th>name</th></tr>
        <tr class="js-no-results no-results" style="display: none">
          <th colspan="2">No matching files</th>
        </tr>
        <tbody class="js-results-list">
        </tbody>
      </table>
    </div>

    <div id="jump-to-line" style="display:none">
      <h2>Jump to Line</h2>
      <form>
        <input class="textfield" type="text">
        <div class="full-button">
          <button type="submit" class="classy">
            <span>Go</span>
          </button>
        </div>
      </form>
    </div>


        

      </div><!-- /.pagehead -->

      

  







<script type="text/javascript">
  GitHub.downloadRepo = '/ningelratter/Sharebox/archives/master'
  GitHub.revType = "master"

  GitHub.repoName = "Sharebox"
  GitHub.controllerName = "blob"
  GitHub.actionName     = "show"
  GitHub.currentAction  = "blob#show"

  
    GitHub.loggedIn = false
  

  
</script>




<div class="flash-messages"></div>


  <div id="commit">
    <div class="group">
        
  <div class="envelope commit">
    <div class="human">
      
        <div class="message"><pre><a href="/ningelratter/Sharebox/commit/30ffb9f4b528feed2b03a8327190b2d4e31092fe">eine XML-Datei wird mit den Userdaten angelegt und beim Start geladen</a> </pre></div>
      

      <div class="actor">
        <div class="gravatar">
          
          <img src="https://secure.gravatar.com/avatar/b8b274d8dc7781a311fd9447ec324f49?s=140&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png" alt="" width="30" height="30"  />
        </div>
        <div class="name"><a href="/ningelratter">ningelratter</a> <span>(author)</span></div>
        <div class="date">
          <time class="js-relative-date" datetime="2011-06-17T14:58:53-07:00" title="2011-06-17 14:58:53">June 17, 2011</time>
        </div>
      </div>

      

    </div>
    <div class="machine">
      <span>c</span>ommit&nbsp;&nbsp;<a href="/ningelratter/Sharebox/commit/30ffb9f4b528feed2b03a8327190b2d4e31092fe" hotkey="c">30ffb9f4b528feed2b03</a><br />
      <span>t</span>ree&nbsp;&nbsp;&nbsp;&nbsp;fb4af52b95db9bf24643<br />
      
        <span>p</span>arent&nbsp;
        
        <a href="/ningelratter/Sharebox/tree/f1ad1b064a7b1c07a6dacc9d41be67175cc0e2d2" hotkey="p">f1ad1b064a7b1c07a6da</a>
      

    </div>
  </div>

    </div>
  </div>



  <div id="slider">

  

    <div class="breadcrumb" data-path="src/de/sharebox/gui/LoginPanel.java/">
      <b><a href="/ningelratter/Sharebox/tree/30ffb9f4b528feed2b03a8327190b2d4e31092fe">Sharebox</a></b> / <a href="/ningelratter/Sharebox/tree/30ffb9f4b528feed2b03a8327190b2d4e31092fe/src">src</a> / <a href="/ningelratter/Sharebox/tree/30ffb9f4b528feed2b03a8327190b2d4e31092fe/src/de">de</a> / <a href="/ningelratter/Sharebox/tree/30ffb9f4b528feed2b03a8327190b2d4e31092fe/src/de/sharebox">sharebox</a> / <a href="/ningelratter/Sharebox/tree/30ffb9f4b528feed2b03a8327190b2d4e31092fe/src/de/sharebox/gui">gui</a> / LoginPanel.java       <span style="display:none" id="clippy_1106">src/de/sharebox/gui/LoginPanel.java</span>
      
      <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
              width="110"
              height="14"
              class="clippy"
              id="clippy" >
      <param name="movie" value="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"/>
      <param name="allowScriptAccess" value="always" />
      <param name="quality" value="high" />
      <param name="scale" value="noscale" />
      <param NAME="FlashVars" value="id=clippy_1106&amp;copied=copied!&amp;copyto=copy to clipboard">
      <param name="bgcolor" value="#FFFFFF">
      <param name="wmode" value="opaque">
      <embed src="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"
             width="110"
             height="14"
             name="clippy"
             quality="high"
             allowScriptAccess="always"
             type="application/x-shockwave-flash"
             pluginspage="http://www.macromedia.com/go/getflashplayer"
             FlashVars="id=clippy_1106&amp;copied=copied!&amp;copyto=copy to clipboard"
             bgcolor="#FFFFFF"
             wmode="opaque"
      />
      </object>
      

    </div>

    <div class="frames">
      <div class="frame frame-center" data-path="src/de/sharebox/gui/LoginPanel.java/" data-canonical-url="/ningelratter/Sharebox/blob/30ffb9f4b528feed2b03a8327190b2d4e31092fe/src/de/sharebox/gui/LoginPanel.java">
        
          <ul class="big-actions">
            
            <li><a class="file-edit-link minibutton" href="/ningelratter/Sharebox/edit/__current_ref__/src/de/sharebox/gui/LoginPanel.java"><span>Edit this file</span></a></li>
          </ul>
        

        <div id="files">
          <div class="file">
            <div class="meta">
              <div class="info">
                <span class="icon"><img alt="Txt" height="16" src="https://a248.e.akamai.net/assets.github.com/images/icons/txt.png" width="16" /></span>
                <span class="mode" title="File Mode">100644</span>
                
                  <span>120 lines (97 sloc)</span>
                
                <span>3.749 kb</span>
              </div>
              <ul class="actions">
                <li><a href="/ningelratter/Sharebox/raw/master/src/de/sharebox/gui/LoginPanel.java" id="raw-url">raw</a></li>
                
                  <li><a href="/ningelratter/Sharebox/blame/master/src/de/sharebox/gui/LoginPanel.java">blame</a></li>
                
                <li><a href="/ningelratter/Sharebox/commits/master/src/de/sharebox/gui/LoginPanel.java">history</a></li>
              </ul>
            </div>
            
  <div class="data type-java">
    
      <table cellpadding="0" cellspacing="0">
        <tr>
          <td>
            <pre class="line_numbers"><span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
</pre>
          </td>
          <td width="100%">
            
              
                <div class="highlight"><pre><div class='line' id='LC1'><span class="kn">package</span> <span class="n">de</span><span class="o">.</span><span class="na">sharebox</span><span class="o">.</span><span class="na">gui</span><span class="o">;</span></div><div class='line' id='LC2'><br/></div><div class='line' id='LC3'><span class="kn">import</span> <span class="nn">java.awt.Color</span><span class="o">;</span></div><div class='line' id='LC4'><span class="kn">import</span> <span class="nn">java.awt.Dimension</span><span class="o">;</span></div><div class='line' id='LC5'><span class="kn">import</span> <span class="nn">java.awt.Font</span><span class="o">;</span></div><div class='line' id='LC6'><span class="kn">import</span> <span class="nn">java.awt.event.ActionEvent</span><span class="o">;</span></div><div class='line' id='LC7'><span class="kn">import</span> <span class="nn">java.awt.event.ActionListener</span><span class="o">;</span></div><div class='line' id='LC8'><br/></div><div class='line' id='LC9'><span class="kn">import</span> <span class="nn">javax.swing.JButton</span><span class="o">;</span></div><div class='line' id='LC10'><span class="kn">import</span> <span class="nn">javax.swing.JLabel</span><span class="o">;</span></div><div class='line' id='LC11'><span class="kn">import</span> <span class="nn">javax.swing.JPasswordField</span><span class="o">;</span></div><div class='line' id='LC12'><span class="kn">import</span> <span class="nn">javax.swing.JTextField</span><span class="o">;</span></div><div class='line' id='LC13'><br/></div><div class='line' id='LC14'><span class="kn">import</span> <span class="nn">de.sharebox.controller.Controller</span><span class="o">;</span></div><div class='line' id='LC15'><span class="kn">import</span> <span class="nn">de.sharebox.models.UserModel</span><span class="o">;</span></div><div class='line' id='LC16'><br/></div><div class='line' id='LC17'><span class="cm">/**</span></div><div class='line' id='LC18'><span class="cm"> * </span></div><div class='line' id='LC19'><span class="cm"> * This GUI is view for the Login. It extends from ChangeablePanel.</span></div><div class='line' id='LC20'><span class="cm"> * </span></div><div class='line' id='LC21'><span class="cm"> * @author Eilin,MW * @version 11.06.11</span></div><div class='line' id='LC22'><span class="cm"> * </span></div><div class='line' id='LC23'><span class="cm"> * </span></div><div class='line' id='LC24'><span class="cm"> */</span></div><div class='line' id='LC25'><br/></div><div class='line' id='LC26'><span class="kd">public</span> <span class="kd">class</span> <span class="nc">LoginPanel</span> <span class="kd">extends</span> <span class="n">ChangeablePanel</span> <span class="o">{</span></div><div class='line' id='LC27'><br/></div><div class='line' id='LC28'>	<span class="cm">/**</span></div><div class='line' id='LC29'><span class="cm">	 * EVERY Panel needs a serialVersionUID</span></div><div class='line' id='LC30'><span class="cm">	 */</span></div><div class='line' id='LC31'>	<span class="kd">private</span> <span class="kd">static</span> <span class="kd">final</span> <span class="kt">long</span> <span class="n">serialVersionUID</span> <span class="o">=</span> <span class="o">-</span><span class="mi">2633038937425341985L</span><span class="o">;</span></div><div class='line' id='LC32'><br/></div><div class='line' id='LC33'>	<span class="kd">public</span> <span class="nf">LoginPanel</span><span class="o">(</span><span class="n">Controller</span> <span class="n">c</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC34'>		<span class="kd">super</span><span class="o">(</span><span class="n">c</span><span class="o">);</span></div><div class='line' id='LC35'>		<span class="n">setLayout</span><span class="o">(</span><span class="kc">null</span><span class="o">);</span></div><div class='line' id='LC36'><br/></div><div class='line' id='LC37'>		<span class="c1">// Welcome Label</span></div><div class='line' id='LC38'>		<span class="n">JLabel</span> <span class="n">lblHerzlichWillkommenBei</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JLabel</span><span class="o">(</span><span class="s">&quot;Herzlich Willkommen bei ShareBoxUltimate&quot;</span><span class="o">);</span></div><div class='line' id='LC39'>		<span class="n">lblHerzlichWillkommenBei</span><span class="o">.</span><span class="na">setFont</span><span class="o">(</span><span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span> <span class="n">Font</span><span class="o">.</span><span class="na">PLAIN</span><span class="o">,</span> <span class="mi">28</span><span class="o">));</span></div><div class='line' id='LC40'>		<span class="n">lblHerzlichWillkommenBei</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">42</span><span class="o">,</span> <span class="mi">11</span><span class="o">,</span> <span class="mi">620</span><span class="o">,</span> <span class="mi">91</span><span class="o">);</span></div><div class='line' id='LC41'>		<span class="n">add</span><span class="o">(</span><span class="n">lblHerzlichWillkommenBei</span><span class="o">);</span></div><div class='line' id='LC42'><br/></div><div class='line' id='LC43'>		<span class="c1">// label statement - what the user have to do</span></div><div class='line' id='LC44'>		<span class="n">JLabel</span> <span class="n">loginLabel</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JLabel</span><span class="o">(</span><span class="s">&quot;Bitte loggen Sie sich ein:&quot;</span><span class="o">);</span></div><div class='line' id='LC45'>		<span class="n">loginLabel</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">212</span><span class="o">,</span> <span class="mi">108</span><span class="o">,</span> <span class="mi">298</span><span class="o">,</span> <span class="mi">67</span><span class="o">);</span></div><div class='line' id='LC46'>		<span class="n">loginLabel</span><span class="o">.</span><span class="na">setFont</span><span class="o">(</span><span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span> <span class="n">Font</span><span class="o">.</span><span class="na">PLAIN</span><span class="o">,</span> <span class="mi">16</span><span class="o">));</span></div><div class='line' id='LC47'>		<span class="n">add</span><span class="o">(</span><span class="n">loginLabel</span><span class="o">);</span></div><div class='line' id='LC48'><br/></div><div class='line' id='LC49'>		<span class="c1">// label statement for registration</span></div><div class='line' id='LC50'>		<span class="n">JLabel</span> <span class="n">lblNochKeinLogin</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JLabel</span><span class="o">(</span><span class="s">&quot;noch kein Login? Dann melden Sie sich jetzt an:&quot;</span><span class="o">);</span></div><div class='line' id='LC51'>		<span class="n">lblNochKeinLogin</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">134</span><span class="o">,</span> <span class="mi">446</span><span class="o">,</span> <span class="mi">376</span><span class="o">,</span> <span class="mi">34</span><span class="o">);</span></div><div class='line' id='LC52'>		<span class="n">lblNochKeinLogin</span><span class="o">.</span><span class="na">setFont</span><span class="o">(</span><span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span> <span class="n">Font</span><span class="o">.</span><span class="na">PLAIN</span><span class="o">,</span> <span class="mi">16</span><span class="o">));</span></div><div class='line' id='LC53'>		<span class="n">add</span><span class="o">(</span><span class="n">lblNochKeinLogin</span><span class="o">);</span></div><div class='line' id='LC54'><br/></div><div class='line' id='LC55'>		<span class="c1">// text field username</span></div><div class='line' id='LC56'>		<span class="kd">final</span> <span class="n">JTextField</span> <span class="n">loginNameField</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JTextField</span><span class="o">(</span><span class="s">&quot;username&quot;</span><span class="o">);</span></div><div class='line' id='LC57'>		<span class="n">loginNameField</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">190</span><span class="o">,</span> <span class="mi">204</span><span class="o">,</span> <span class="mi">110</span><span class="o">,</span> <span class="mi">50</span><span class="o">);</span></div><div class='line' id='LC58'>		<span class="n">add</span><span class="o">(</span><span class="n">loginNameField</span><span class="o">);</span></div><div class='line' id='LC59'>		<span class="n">loginNameField</span><span class="o">.</span><span class="na">setFont</span><span class="o">(</span><span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span> <span class="n">Font</span><span class="o">.</span><span class="na">PLAIN</span><span class="o">,</span> <span class="mi">16</span><span class="o">));</span></div><div class='line' id='LC60'><br/></div><div class='line' id='LC61'>		<span class="c1">// text field password</span></div><div class='line' id='LC62'>		<span class="kd">final</span> <span class="n">JPasswordField</span> <span class="n">loginPasswordField</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JPasswordField</span><span class="o">(</span><span class="s">&quot;password&quot;</span><span class="o">);</span></div><div class='line' id='LC63'>		<span class="n">loginPasswordField</span><span class="o">.</span><span class="na">setPreferredSize</span><span class="o">(</span><span class="k">new</span> <span class="n">Dimension</span><span class="o">(</span><span class="mi">53</span><span class="o">,</span> <span class="mi">20</span><span class="o">));</span></div><div class='line' id='LC64'>		<span class="n">loginPasswordField</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">316</span><span class="o">,</span> <span class="mi">206</span><span class="o">,</span> <span class="mi">128</span><span class="o">,</span> <span class="mi">50</span><span class="o">);</span></div><div class='line' id='LC65'>		<span class="n">add</span><span class="o">(</span><span class="n">loginPasswordField</span><span class="o">);</span></div><div class='line' id='LC66'>		<span class="n">loginPasswordField</span><span class="o">.</span><span class="na">setFont</span><span class="o">(</span><span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span> <span class="n">Font</span><span class="o">.</span><span class="na">PLAIN</span><span class="o">,</span> <span class="mi">16</span><span class="o">));</span></div><div class='line' id='LC67'><br/></div><div class='line' id='LC68'>		<span class="c1">// labe text is only shown if login data is invalid</span></div><div class='line' id='LC69'>		<span class="kd">final</span> <span class="n">JLabel</span> <span class="n">loginFailedLabel</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JLabel</span><span class="o">(</span><span class="s">&quot;&quot;</span><span class="o">);</span></div><div class='line' id='LC70'>		<span class="n">loginFailedLabel</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">200</span><span class="o">,</span> <span class="mi">160</span><span class="o">,</span> <span class="mi">300</span><span class="o">,</span> <span class="mi">50</span><span class="o">);</span></div><div class='line' id='LC71'>		<span class="n">loginFailedLabel</span><span class="o">.</span><span class="na">setFont</span><span class="o">(</span><span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span> <span class="n">Font</span><span class="o">.</span><span class="na">PLAIN</span><span class="o">,</span> <span class="mi">16</span><span class="o">));</span></div><div class='line' id='LC72'>		<span class="n">loginFailedLabel</span><span class="o">.</span><span class="na">setForeground</span><span class="o">(</span><span class="n">Color</span><span class="o">.</span><span class="na">red</span><span class="o">);</span></div><div class='line' id='LC73'>		<span class="n">add</span><span class="o">(</span><span class="n">loginFailedLabel</span><span class="o">);</span></div><div class='line' id='LC74'><br/></div><div class='line' id='LC75'>		<span class="c1">// button register</span></div><div class='line' id='LC76'>		<span class="n">JButton</span> <span class="n">registerButton</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JButton</span><span class="o">(</span><span class="s">&quot;Registrieren&quot;</span><span class="o">);</span></div><div class='line' id='LC77'>		<span class="n">registerButton</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">156</span><span class="o">,</span> <span class="mi">508</span><span class="o">,</span> <span class="mi">322</span><span class="o">,</span> <span class="mi">50</span><span class="o">);</span></div><div class='line' id='LC78'><br/></div><div class='line' id='LC79'>		<span class="c1">// actionhandling register button</span></div><div class='line' id='LC80'>		<span class="n">ActionListener</span> <span class="n">registerButtonClickedActionListener</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ActionListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC81'>			<span class="nd">@Override</span></div><div class='line' id='LC82'>			<span class="c1">// change the view when user push the register button</span></div><div class='line' id='LC83'>			<span class="kd">public</span> <span class="kt">void</span> <span class="nf">actionPerformed</span><span class="o">(</span><span class="n">ActionEvent</span> <span class="n">f</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC84'><br/></div><div class='line' id='LC85'>				<span class="n">changePanel</span><span class="o">(</span><span class="k">new</span> <span class="n">RegisterPanel</span><span class="o">(</span><span class="n">controller</span><span class="o">));</span></div><div class='line' id='LC86'>			<span class="o">}</span></div><div class='line' id='LC87'>		<span class="o">};</span></div><div class='line' id='LC88'><br/></div><div class='line' id='LC89'>		<span class="n">registerButton</span><span class="o">.</span><span class="na">addActionListener</span><span class="o">(</span><span class="n">registerButtonClickedActionListener</span><span class="o">);</span></div><div class='line' id='LC90'>		<span class="n">add</span><span class="o">(</span><span class="n">registerButton</span><span class="o">);</span></div><div class='line' id='LC91'><br/></div><div class='line' id='LC92'>		<span class="c1">// button login and actionhandling</span></div><div class='line' id='LC93'>		<span class="n">JButton</span> <span class="n">loginButton</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JButton</span><span class="o">(</span><span class="s">&quot;Login&quot;</span><span class="o">);</span></div><div class='line' id='LC94'>		<span class="n">loginButton</span><span class="o">.</span><span class="na">setBounds</span><span class="o">(</span><span class="mi">236</span><span class="o">,</span> <span class="mi">282</span><span class="o">,</span> <span class="mi">130</span><span class="o">,</span> <span class="mi">72</span><span class="o">);</span></div><div class='line' id='LC95'>		<span class="n">add</span><span class="o">(</span><span class="n">loginButton</span><span class="o">);</span></div><div class='line' id='LC96'>		<span class="n">loginButton</span><span class="o">.</span><span class="na">setFont</span><span class="o">(</span><span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span> <span class="n">Font</span><span class="o">.</span><span class="na">PLAIN</span><span class="o">,</span> <span class="mi">16</span><span class="o">));</span></div><div class='line' id='LC97'>		<span class="n">ActionListener</span> <span class="n">loginButtonClickedActionListener</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ActionListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC98'><br/></div><div class='line' id='LC99'>			<span class="nd">@Override</span></div><div class='line' id='LC100'>			<span class="kd">public</span> <span class="kt">void</span> <span class="nf">actionPerformed</span><span class="o">(</span><span class="n">ActionEvent</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC101'>				<span class="n">String</span> <span class="n">name</span> <span class="o">=</span> <span class="n">loginNameField</span><span class="o">.</span><span class="na">getText</span><span class="o">();</span></div><div class='line' id='LC102'>				<span class="c1">// string konstruktor - macht aus dem chararray einen string</span></div><div class='line' id='LC103'><br/></div><div class='line' id='LC104'>				<span class="n">String</span> <span class="n">password</span> <span class="o">=</span> <span class="k">new</span> <span class="n">String</span><span class="o">(</span><span class="n">loginPasswordField</span><span class="o">.</span><span class="na">getPassword</span><span class="o">());</span></div><div class='line' id='LC105'>				<span class="n">User</span> <span class="n">user</span> <span class="o">=</span> <span class="n">controller</span><span class="o">.</span><span class="na">getUser</span><span class="o">(</span><span class="n">name</span><span class="o">,</span> <span class="n">password</span><span class="o">);</span></div><div class='line' id='LC106'><br/></div><div class='line' id='LC107'>				<span class="k">if</span> <span class="o">(</span><span class="n">user</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC108'>					<span class="n">UserModel</span> <span class="n">userModel</span> <span class="o">=</span> <span class="k">new</span> <span class="n">UserModel</span><span class="o">(</span><span class="n">user</span><span class="o">);</span></div><div class='line' id='LC109'>					<span class="n">changePanel</span><span class="o">(</span><span class="k">new</span> <span class="n">HomePanel</span><span class="o">(</span><span class="n">controller</span><span class="o">,</span> <span class="n">userModel</span><span class="o">));</span></div><div class='line' id='LC110'>				<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC111'>					<span class="c1">// show error message</span></div><div class='line' id='LC112'>					<span class="n">loginFailedLabel</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Falsche Login-Daten du Pfeife...&quot;</span><span class="o">);</span></div><div class='line' id='LC113'>				<span class="o">}</span></div><div class='line' id='LC114'>			<span class="o">}</span></div><div class='line' id='LC115'>		<span class="o">};</span></div><div class='line' id='LC116'><br/></div><div class='line' id='LC117'>		<span class="n">loginButton</span><span class="o">.</span><span class="na">addActionListener</span><span class="o">(</span><span class="n">loginButtonClickedActionListener</span><span class="o">);</span></div><div class='line' id='LC118'><br/></div><div class='line' id='LC119'>	<span class="o">}</span></div><div class='line' id='LC120'><span class="o">}</span></div></pre></div>
              
            
          </td>
        </tr>
      </table>
    
  </div>


          </div>
        </div>
      </div>
    </div>
  

  </div>


<div class="frame frame-loading" style="display:none;">
  <img src="https://a248.e.akamai.net/assets.github.com/images/modules/ajax/big_spinner_336699.gif" height="32" width="32">
</div>

    </div>
  
      
    </div>

    <div id="footer" class="clearfix">
      <div class="site">
        
          <div class="sponsor">
            <a href="http://www.rackspace.com" class="logo">
              <img alt="Dedicated Server" height="36" src="https://a248.e.akamai.net/assets.github.com/images/modules/footer/rackspace_logo.png?v2" width="38" />
            </a>
            Powered by the <a href="http://www.rackspace.com ">Dedicated
            Servers</a> and<br/> <a href="http://www.rackspacecloud.com">Cloud
            Computing</a> of Rackspace Hosting<span>&reg;</span>
          </div>
        

        <ul class="links">
          
            <li class="blog"><a href="https://github.com/blog">Blog</a></li>
            <li><a href="https://github.com/about">About</a></li>
            <li><a href="https://github.com/contact">Contact &amp; Support</a></li>
            <li><a href="https://github.com/training">Training</a></li>
            <li><a href="http://jobs.github.com">Job Board</a></li>
            <li><a href="http://shop.github.com">Shop</a></li>
            <li><a href="http://developer.github.com">API</a></li>
            <li><a href="http://status.github.com">Status</a></li>
          
        </ul>
        <ul class="sosueme">
          <li class="main">&copy; 2011 <span id="_rrt" title="0.17158s from fe1.rs.github.com">GitHub</span> Inc. All rights reserved.</li>
          <li><a href="/site/terms">Terms of Service</a></li>
          <li><a href="/site/privacy">Privacy</a></li>
          <li><a href="https://github.com/security">Security</a></li>
        </ul>
      </div>
    </div><!-- /#footer -->

    <script>window._auth_token = "0c2a6eb493e2d0d76ee89cc644828ed78d4cc15b"</script>
    

<div id="keyboard_shortcuts_pane" class="instapaper_ignore readability-extra" style="display:none">
  <h2>Keyboard Shortcuts <small><a href="#" class="js-see-all-keyboard-shortcuts">(see all)</a></small></h2>

  <div class="columns threecols">
    <div class="column first">
      <h3>Site wide shortcuts</h3>
      <dl class="keyboard-mappings">
        <dt>s</dt>
        <dd>Focus site search</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>?</dt>
        <dd>Bring up this help dialog</dd>
      </dl>
    </div><!-- /.column.first -->

    <div class="column middle" style='display:none'>
      <h3>Commit list</h3>
      <dl class="keyboard-mappings">
        <dt>j</dt>
        <dd>Move selected down</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>k</dt>
        <dd>Move selected up</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>t</dt>
        <dd>Open tree</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>p</dt>
        <dd>Open parent</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>c <em>or</em> o <em>or</em> enter</dt>
        <dd>Open commit</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>y</dt>
        <dd>Expand URL to its canonical form</dd>
      </dl>
    </div><!-- /.column.first -->

    <div class="column last" style='display:none'>
      <h3>Pull request list</h3>
      <dl class="keyboard-mappings">
        <dt>j</dt>
        <dd>Move selected down</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>k</dt>
        <dd>Move selected up</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>o <em>or</em> enter</dt>
        <dd>Open issue</dd>
      </dl>
    </div><!-- /.columns.last -->

  </div><!-- /.columns.equacols -->

  <div style='display:none'>
    <div class="rule"></div>

    <h3>Issues</h3>

    <div class="columns threecols">
      <div class="column first">
        <dl class="keyboard-mappings">
          <dt>j</dt>
          <dd>Move selected down</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>k</dt>
          <dd>Move selected up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>x</dt>
          <dd>Toggle select target</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>o <em>or</em> enter</dt>
          <dd>Open issue</dd>
        </dl>
      </div><!-- /.column.first -->
      <div class="column middle">
        <dl class="keyboard-mappings">
          <dt>I</dt>
          <dd>Mark selected as read</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>U</dt>
          <dd>Mark selected as unread</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>e</dt>
          <dd>Close selected</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>y</dt>
          <dd>Remove selected from view</dd>
        </dl>
      </div><!-- /.column.middle -->
      <div class="column last">
        <dl class="keyboard-mappings">
          <dt>c</dt>
          <dd>Create issue</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>l</dt>
          <dd>Create label</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>i</dt>
          <dd>Back to inbox</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>u</dt>
          <dd>Back to issues</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>/</dt>
          <dd>Focus issues search</dd>
        </dl>
      </div>
    </div>
  </div>

  <div style='display:none'>
    <div class="rule"></div>

    <h3>Network Graph</h3>
    <div class="columns equacols">
      <div class="column first">
        <dl class="keyboard-mappings">
          <dt><span class="badmono">←</span> <em>or</em> h</dt>
          <dd>Scroll left</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">→</span> <em>or</em> l</dt>
          <dd>Scroll right</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">↑</span> <em>or</em> k</dt>
          <dd>Scroll up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">↓</span> <em>or</em> j</dt>
          <dd>Scroll down</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>t</dt>
          <dd>Toggle visibility of head labels</dd>
        </dl>
      </div><!-- /.column.first -->
      <div class="column last">
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">←</span> <em>or</em> shift h</dt>
          <dd>Scroll all the way left</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">→</span> <em>or</em> shift l</dt>
          <dd>Scroll all the way right</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">↑</span> <em>or</em> shift k</dt>
          <dd>Scroll all the way up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">↓</span> <em>or</em> shift j</dt>
          <dd>Scroll all the way down</dd>
        </dl>
      </div><!-- /.column.last -->
    </div>
  </div>

  <div >
    <div class="rule"></div>
    <div class="columns threecols">
      <div class="column first" >
        <h3>Source Code Browsing</h3>
        <dl class="keyboard-mappings">
          <dt>t</dt>
          <dd>Activates the file finder</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>l</dt>
          <dd>Jump to line</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>y</dt>
          <dd>Expand URL to its canonical form</dd>
        </dl>
      </div>
    </div>
  </div>
</div>

    <div id="markdown-help" class="instapaper_ignore readability-extra">
  <h2>Markdown Cheat Sheet</h2>

  <div class="cheatsheet-content">

  <div class="mod">
    <div class="col">
      <h3>Format Text</h3>
      <p>Headers</p>
      <pre>
# This is an &lt;h1&gt; tag
## This is an &lt;h2&gt; tag
###### This is an &lt;h6&gt; tag</pre>
     <p>Text styles</p>
     <pre>
*This text will be italic*
_This will also be italic_
**This text will be bold**
__This will also be bold__

*You **can** combine them*
</pre>
    </div>
    <div class="col">
      <h3>Lists</h3>
      <p>Unordered</p>
      <pre>
* Item 1
* Item 2
  * Item 2a
  * Item 2b</pre>
     <p>Ordered</p>
     <pre>
1. Item 1
2. Item 2
3. Item 3
   * Item 3a
   * Item 3b</pre>
    </div>
    <div class="col">
      <h3>Miscellaneous</h3>
      <p>Images</p>
      <pre>
![GitHub Logo](/images/logo.png)
Format: ![Alt Text](url)
</pre>
     <p>Links</p>
     <pre>
http://github.com - automatic!
[GitHub](http://github.com)</pre>
<p>Blockquotes</p>
     <pre>
As Kanye West said:
> We're living the future so
> the present is our past.
</pre>
    </div>
  </div>
  <div class="rule"></div>

  <h3>Code Examples in Markdown</h3>
  <div class="col">
      <p>Syntax highlighting with <a href="http://github.github.com/github-flavored-markdown/" title="GitHub Flavored Markdown">GFM</a></p>
      <pre>
```javascript
function fancyAlert(arg) {
  if(arg) {
    $.facebox({div:'#foo'})
  }
}
```</pre>
    </div>
    <div class="col">
      <p>Or, indent your code 4 spaces</p>
      <pre>
Here is a Python code example
without syntax highlighting:

    def foo:
      if not bar:
        return true</pre>
    </div>
    <div class="col">
      <p>Inline code for comments</p>
      <pre>
I think you should use an
`&lt;addr&gt;` element here instead.</pre>
    </div>
  </div>

  </div>
</div>
    

    <!--[if IE 8]>
    <script type="text/javascript" charset="utf-8">
      $(document.body).addClass("ie8")
    </script>
    <![endif]-->

    <!--[if IE 7]>
    <script type="text/javascript" charset="utf-8">
      $(document.body).addClass("ie7")
    </script>
    <![endif]-->

    
    
    
    <script type="text/javascript">(function(){var d=document;var e=d.createElement("script");e.async=true;e.src="https://d1ros97qkrwjf5.cloudfront.net/12/eum/rum.js	";e.type="text/javascript";var s=d.getElementsByTagName("script")[0];s.parentNode.insertBefore(e,s);})();NREUMQ.push(["nrf2","beacon-1.newrelic.com","2f94e4d8c2",64799,"dw1bEBZcX1RWRhoEClsAGhcMXEQ=",0.0,169,new Date().getTime()])</script>
  </body>
</html>

