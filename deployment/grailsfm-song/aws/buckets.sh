#!/bin/bash
awslocal s3api create-bucket --bucket songbucket --create-bucket-configuration LocationConstraint=eu-north-1
