function submit1(rType) {
    document.getElementById('response').innerText = "Processing .....";
    //if (!$form.checkValidity || $form.checkValidity()) {
    if (rType == 1) {
        responseType = 'json';
        rType = 'getAllInstances';
    }
    else if (rType == 2) {
        responseType = 'json';
        rType = 'getSingleInstances';
    }
    else if (rType == 3) {
        responseType = 'text';
        rType = 'deleteSingleInstance';
    }
    else if (rType == 4) {
        responseType = 'text';
        rType = 'deleteCoherenceDataTier';
    }
    else if (rType == 5) {
        responseType = 'text';
        rType = 'addCoherenceDataTier';
    }
    else if (rType == 6) {
        responseType = 'json';
        rType = 'getStatus';
    }
    var apiurl = "cloudapi?requestType=" + rType;
    apiurl += "&userName=" + document.getElementById('userName').value;
    apiurl += "&password=" + encodeURIComponent(document.getElementById('password').value);
    apiurl += "&iDomain=" + document.getElementById('iDomain').value;
    if (document.getElementById('serviceID') != null) {
        apiurl += "&serviceID=" + document.getElementById('serviceID').value;
    }

    if (document.getElementById('dbausername') != null) {
        apiurl += "&dbausername=" + document.getElementById('dbausername').value;
    }

    if (document.getElementById('dbapwd') != null) {
        apiurl += "&dbapwd=" + encodeURIComponent(document.getElementById('dbapwd').value);
    }

    if (document.getElementById('dbaForce') != null) {
        apiurl += "&dbaForce=" + document.getElementById('dbaForce').value;
    }

    if (document.getElementById('clusterName') != null) {
        apiurl += "&clusterName=" + document.getElementById('clusterName').value;
    }

    if (document.getElementById('scalingUnitName') != null) {
        apiurl += "&scalingUnitName=" + document.getElementById('scalingUnitName').value;
    }

    if (document.getElementById('scalingUnitCount') != null) {
        apiurl += "&scalingUnitCount=" + document.getElementById('scalingUnitCount').value;
    }

    if (document.getElementById('clusterType') != null) {
        apiurl += "&clusterType=" + document.getElementById('clusterType').value;
    }

    if (document.getElementById('scalingUnitName') != null) {
        apiurl += "&scalingUnitName=" + document.getElementById('scalingUnitName').value;
    }

    if (document.getElementById('responseURL') != null) {
        apiurl += "&responseURL=" + encodeURIComponent(document.getElementById('responseURL').value);
    }

    var jqxhr = $.get(apiurl, function (r) {
        if (responseType == 'json') {
            var r = JSON.stringify(r, null, 2);
            document.getElementById('response').innerText = r;
        }
        else {
            document.getElementById('response').innerText = r;
        }
    }).done(function () {

    }).fail(function () {
        document.getElementById('response').innerText = "Error in Executing the request";
    }).always(function () {

    });

    // Perform other work here ...
    // Set another completion function for the request above
    jqxhr.always(function () {

    });
    //}
}

function getCommonFields() {
document.getElementById('response').innerHTML = "";
var str = '';
str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Cloud User Name" id="userName" name="userName" type="text" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Cloud Password" name="password" id="password" type="password" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Cloud Identity Domain" id="iDomain" name="iDomain" type="text" required autofocus>';
    str += '</div>';

	return str;

}

function link1() {
    var str = '';

    str += '<form role="form" method="GET">';
    str += '<h1>View All Instances</h1>';
    str += '<fieldset>';
    
	str += getCommonFields();

    str += '<button class="btn btn-sm btn-success" onClick="submit1(1);return false">Submit</button>';
    str += '</fieldset>';

    str += '</form>';

    document.getElementById('frmContent').innerHTML = str;
}

function link2() {
    var str = '';

    str += '<form role="form" method="GET">';
    str += '<h1>View Single Instance</h1>';
    str += '<fieldset>';
    
	str += getCommonFields();

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Service ID" id="serviceID" name="serviceID" type="text" required autofocus>';
    str += '</div>';

    str += '<button class="btn btn-sm btn-success" onClick="submit1(2);return false">Submit</button>';
    str += '</fieldset>';

    str += '</form>';

    document.getElementById('frmContent').innerHTML = str;
}

function link3() {
    var str = '';

    str += '<form role="form" method="GET">';
    str += '<h1>Delete Instances</h1>';
    str += '<fieldset>';
    
	str += getCommonFields();

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Service ID" id="serviceID" name="serviceID" required type="text" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="DB User" id="dbausername" name="dbausername" required type="text" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="DB Password" id="dbapwd" name="dbapwd" required type="password" required autofocus>';
    str += '</div>';

    str += '<button class="btn btn-sm btn-success" onclick="submit1(3);return false">Submit</button>';
    str += '</fieldset>';

    str += '</form>';

    document.getElementById('frmContent').innerHTML = str;
}

function link4() {
    var str = '';

    str += '<form role="form" method="GET">';
    str += '<h1>Delete Coherence Tier</h1>';
    str += '<fieldset>';
   
    str += getCommonFields();

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Service ID" id="serviceID" name="serviceID" required type="text" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Cluster Name" id="clusterName" name="clusterName" required type="text" required autofocus>';
    str += '</div>';

    str += '<button class="btn btn-sm btn-success" onclick="submit1(4);return false">Submit</button>';
    str += '</fieldset>';

    str += '</form>';

    document.getElementById('frmContent').innerHTML = str;
}

function link5() {
    var str = '';

    str += '<form role="form" method="GET">';
    str += '<h1>Add Coherence Tier</h1>';
    str += '<fieldset>';
    
	str += getCommonFields();

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Service ID" id="serviceID" name="serviceID" required type="text" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Cluster Type" id="clusterType" value="DG" readonly name="clusterType" type="text" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Scaling Unit Count" value="1" id="scalingUnitCount" readonly name="scalingUnitCount" required type="text" required autofocus>';
    str += '</div>';

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Scaling Unit Name" value="BASIC" id="scalingUnitName" readonly required name="scalingUnitName" type="text" required autofocus>';
    str += '</div>';

    str += '<button class="btn btn-sm btn-success" onclick="submit1(5);return false">Submit</button>';
    str += '</fieldset>';

    str += '</form>';

    document.getElementById('frmContent').innerHTML = str;
}

function link6() {
    var str = '';

    str += '<form role="form" method="GET">';
    str += '<h1>View Compute Status	</h1>';
    str += '<fieldset>';
    
	str += getCommonFields();

    str += '<div class="form-group">';
    str += '<input class="form-control" placeholder="Response Body URL" id="responseURL" name="responseURL" type="text" required autofocus>';
    str += '</div>';

    str += '<button class="btn btn-sm btn-success" onClick="submit1(6);return false">Submit</button>';
    str += '</fieldset>';

    str += '</form>';

    document.getElementById('frmContent').innerHTML = str;
}