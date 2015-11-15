"use strict"
/*!
 * @autor   WeRDying
 * @version 1.0
 * @e-mail  heyin223@163.com
 */

var xmlFileProvince  = "http://localhost:8888/etc/Provinces/xml";
var xmlFileCity      = "http://localhost:8888/etc/Cities/xml";
var xmlFileDistricts = "http://localhost:8888/etc/Districts/xml";

var nodeNameProvince = "Province";
var nodeNameCity     = "City";
var nodeNameDistrict = "District";

var xmlDocP = '';
var xmlDocC = '';
var xmlDocD = '';

/*加载文件 开始*/
function laodFile (xmlFile) {
    var xmlDoc = "";
    if(window.ActiveXObject){ //IE
        var activeXNameList = new Array("MSXML2.DOMDocument.6.0","MSXML2.DOMDocument.5.0","MSXML2.DOMDocument.4.0","MSXML2.DOMDocument.3.0","MSXML2.DOMDocument","Microsoft.XMLDOM","MSXML.DOMDocument");
        for (var i = 0; i < activeXNameList.length; i++) {
            try{
                xmlDoc = new ActiveXObject(activeXNameList[i]);
                xmlDoc.async = false;//waiting for loading file, in case for error
                xmlDoc.load(xmlFile);//load xml file
                // alert("IE ok");
            }catch(e){
                continue;
            }
            if(xmlDoc) break;
        }

    }else if(navigator.userAgent.indexOf("Firefox")>0){//document.implementation && document.implementation.createDocument非ie
        xmlDoc = document.implementation.createDocument("","",null);
        xmlDoc.async = false;//waiting for loading file, in case for error
        xmlDoc.load(xmlFile);//load xml file
        // alert("Firefox ok");

    }else if(window.XMLHttpRequest){//chrome
        var d=new Date();
        var xmlhttp = new window.XMLHttpRequest();
        xmlhttp.open("GET",xmlFile,false);
        xmlhttp.send(null);
        if(xmlhttp.readyState == 4){
            xmlDoc = xmlhttp.responseXML.documentElement;
            if (xmlDoc == null) {
                alert("xmlDoc null");
            }

        }
    }else{
        alert("can not create xml DOM object ,please update your browser!!");
    }
    return xmlDoc;
}
/*加载文件 结束*/

/*读取文件内容 开始*/
function readFile(xmlFile,nodeName){
    var xmlDoc = laodFile(xmlFile);
    if (xmlDoc.documentElement) {
        var nodeList = xmlDoc.documentElement.getElementsByTagName(nodeName);
    }else{
        var nodeList = xmlDoc.getElementsByTagName(nodeName);
    }
    // console.log(nodeList.length);
    if(nodeList == null){
        alert("nodeList null 68");
    }
    return nodeList;
}
/*读取文件内容 结束*/
var provinceVal = document.getElementById("province-value");
var cityVal     = document.getElementById("city-value");
var districtVal = document.getElementById("district-value");

var province = document.getElementById("province");
var city     = document.getElementById("city");
var district = document.getElementById("district");

function showP(){
    province.style.display = "block";
}
function showC(){
    city.style.display = "block";
}
function showD(){
    district.style.display = "block";
}
window.onload = function(){



    // return place list
    var a = readFile(xmlFileProvince,nodeNameProvince);

    /*设置省*/
    for(var i = 0; i < a.length ; i ++){
        // console.log("nodeList:"+a[i].innerHTML);//get province_name
        var location = a[i];
        var option = document.createElement("li");
        option.innerHTML = location.innerHTML;
        option.setAttribute("value",location.getAttribute("ID"));
        option.setAttribute("onclick","autoAddCity(event);");
        // province.setAttribute("onchange","autoAddCity(event);");
        province.appendChild(option);//添加省 选项
    }
};

function testfuncton(){
    alert("testfuncton");
}
function autoAddCity(event){
    var provinceName = event.target.innerHTML;
    province.setAttribute("data-province",provinceName);
    provinceVal.setAttribute("value",provinceName);
    var provinceID = event.target.getAttribute("value");
    console.log(provinceName+provinceID);
    console.log("autoAddCity function");
    addCity(provinceID);
    province.style.display = "none";
    cityVal.setAttribute("value","");
    districtVal.setAttribute("value","");
    district.innerHTML = "";
}
function autoAddDistrict(event) {
    var cityName = event.target.innerHTML;
    city.setAttribute("data-city",cityName);
    cityVal.setAttribute("value",cityName);
    var cityID = event.target.getAttribute("value");
    console.log(cityName+cityID);
    addDistrict(cityID);
    city.style.display = "none";
    districtVal.setAttribute("value","");

}
function setLocation(event){
    var location = "";
    var districtName = event.target.innerHTML;
    var citn = city.getAttribute("data-city");
    var prov = province.getAttribute("data-province");
    var locationStr = document.getElementById("location-str");
    location = prov+"|"+citn+"|"+districtName;
    locationStr.setAttribute("data-location",location);
    locationStr.setAttribute("value",location);
    district.setAttribute("data-dist",districtName);
    districtVal.setAttribute("value",districtName);
    district.setAttribute("data-location",location);
    district.setAttribute("value",location);
    // alert(location);
    district.style.display = "none";
}

function addCity(provinceID){
    var list = readFile(xmlFileCity,nodeNameCity);
    city.innerHTML = "";//清空之前省的城市选项
    var option = document.createElement("li");
    option.innerHTML = "未选择城市";
    city.appendChild(option);//添加城市选项提示

    for(var i = 0; i < list.length; i++){
        var location = list[i];
        if(location.getAttribute("PID") == provinceID){
            var option = document.createElement("li");
            option.innerHTML = location.innerHTML;
            option.setAttribute("value",location.getAttribute("ID"));
            option.setAttribute("onclick","autoAddDistrict(event);");
            city.appendChild(option);//添加城市选项
        }
    }
}

function addDistrict(cityID){
    var list = readFile(xmlFileDistricts,nodeNameDistrict);
    district.innerHTML = "";//清空之前省的城市选项
    var option = document.createElement("li");
    option.innerHTML = "未选择区";
    district.appendChild(option);//添加城市选项提示
    for(var i = 0; i < list.length; i++){
        var location = list[i];
        if(location.getAttribute("CID") == cityID){
            var option = document.createElement("li");
            option.innerHTML = location.innerHTML;
            option.setAttribute("value",location.getAttribute("ID"));
            option.setAttribute("onclick","setLocation(event);");
            district.appendChild(option);//添加城市选项
        }
    }
}

